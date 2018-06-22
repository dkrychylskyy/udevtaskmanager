// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);

    /**
     * Modification duree en changant date debut
     */
    $("#dateDebut").change(function () {
        calculerDuree();
    });
    /**
     * Modification duree en changant date debut
     */
    $("#dateFin").change(function () {
        calculerDuree();
    });

    /**
     * Evenement : change duree
     */
    $("#duree").change(function () {
        calculerDateFin();
    });

    /**
     *
     * @returns {(*|jQuery)[]}
     */
    function initDates() {
        var dateDebutDay = +($("#dateDebut_day").val());
        var dateDebutMonth = +($("#dateDebut_month").val());
        var dateDebutYear = +($("#dateDebut_year").val());
        var dateFinDay = +($("#dateFin_day").val());
        var dateFinMonth = +($("#dateFin_month").val());
        var dateFinYear = +($("#dateFin_year").val());

        var dateDebut = new Date(dateDebutYear,dateDebutMonth-1,dateDebutDay,0,0);
        var dateFin = new Date(dateFinYear,dateFinMonth-1,dateFinDay,0,0);

        var duree = +($("#duree").val());
        var arr = new Array();
        arr.dateDebut = dateDebut;
        arr.dateFin = dateFin;
        arr.duree = duree;

        return arr;
    }
    //Convert millisec en jours
    function dhm(t){
        var cd = 24 * 60 * 60 * 1000,
            ch = 60 * 60 * 1000,
            d = Math.floor(t / cd),
            h = Math.floor( (t - d * cd) / ch),
            m = Math.round( (t - d * cd - h * ch) / 60000),
            pad = function(n){ return n < 10 ? '0' + n : n; };
        if( m === 60 ){
            h++;
            m = 0;
        }
        if( h === 24 ){
            d++;
            h = 0;
        }
        // return [d, pad(h), pad(m)].join(':');
        return d;
    }

    function calculerDuree() {
        var datesDebutFinPeriod = initDates(); // array
        console.log(datesDebutFinPeriod.dateDebut);
        if (datesDebutFinPeriod.dateDebut < datesDebutFinPeriod.dateFin){
            var millisecEntre = datesDebutFinPeriod.dateFin-datesDebutFinPeriod.dateDebut;
            var newDuree = dhm(millisecEntre);
            $("#duree").val(Math.abs(newDuree));
            $("#errorDuree").hide("slow");
        } else {
            //$("#duree").html("Error: Date debut doit etre moins de date fin !");
            var ell =  $("#errorDuree");
            $("#errorDuree").show("slow");
        }
    }

    function calculerDateFin() {
        var datesArr = initDates();
        // On ajout duree à la date de fin. Res en millisec
        var dateFinInMillisec = datesArr.dateFin.setDate(datesArr.dateDebut.getDate()+datesArr.duree);
        var newDateFinEntier = new Date(dateFinInMillisec);

        // On decoup date par jour, moins, annee
        var day = (newDateFinEntier.getDate());
        var month = ((newDateFinEntier.getMonth() + 1));
        var year = newDateFinEntier.getFullYear();
        $("#dateFin_day").val(day);
        $("#dateFin_month").val(month);
        $("#dateFin_year").val(year);

    }
}
