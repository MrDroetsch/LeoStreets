package me.bunny;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static me.bunny.Messages.*;

public class Main {

    public static final Locale defaultLocale = Locale.ENGLISH;

    public static void main(String[] args) {

        System.out.println("\n---------------------------------\n");

        System.out.println("Default Locale:");
        System.out.println(getMessageText(Msg.TXT_WELCOME));
        System.out.println(getMessageText(Msg.ERR_NOT_ENOUGH_MONEY));

        System.out.println("\n---------------------------------\n");

        System.out.println("Fixed Locale:");
        System.out.println(getMessageText(Msg.TXT_WELCOME, Locale.ENGLISH));
        System.out.println(getMessageText(Msg.ERR_NOT_ENOUGH_MONEY, Locale.GERMAN));

        System.out.println("\n---------------------------------\n");

        JSONParser parser = new JSONParser();

        try {
            JSONObject jobj = (JSONObject) parser.parse(new FileReader("E:\\IntelliJ\\Hobby_Programming\\locales\\src\\main\\resources\\Streets.json"));

            JSONArray streets = (JSONArray) jobj.get("streets");

            List<Street> streetsList = streets.stream().map(obj -> Street.deserialize((JSONObject) obj)).toList();

            streetsList.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}