package com.udev.tskmngr;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Set;

public class JSONParsing {
    private static JSONParsing ourInstance = new JSONParsing();

    public static JSONParsing getInstance() {
        return ourInstance;
    }

    private JSONParsing() {

    }

    public List<User> parserJsonFichier(){
        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:\\TMPdata\\UsersAndTaches.json"));
            List<User> userList = new Gson().fromJson(br,new TypeToken<List<User>>() {}.getType());
            return userList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    };
}
