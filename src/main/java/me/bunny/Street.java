package me.bunny;

import org.json.simple.JSONObject;
import org.json.simple.JsonObject;

import java.util.List;

public class Street {

    private int kosten;
    private int id;
    private String name;

    public Street(int id, int kosten, String name) {
        this.id = id;
        this.kosten = kosten;
        this.name = name;
    }

    public int getKosten() {
        return kosten;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Street[id=" + id + ",kosten=" + kosten + ",name=" + name + "]";
    }

    public static Street deserialize(JSONObject obj) {
        String name = (String) obj.get("Name");
        long id = (long) obj.get("ID");
        long kosten = (long) obj.get("Preis");
        return new Street((int) id, (int) kosten, name);
    }

}
