package model;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

public class ListOfProfiles implements Writable {
    private  List<Profile> profileList;
    private String name;

    public ListOfProfiles() {
        profileList = new ArrayList<Profile>();
        name = "ListOfProfiles";
    }

    //returns wether the listofprofiles field is empty
    public boolean isEmpty() {
        return (profileList.isEmpty());
    }


    public List<Profile> getProfiles() {
        return profileList;
    }

    //adds profile to list
    public void add(Profile prof) {
        profileList.add(prof);
    }

    public String getName() {
        return name;
    }


    //Finds where in the list of profile a peticular profile is, returns -1 if there is no profile.
    public int getProfPosition(String name) {
        int count = 0;
        for (Profile prof : profileList) {
            count++;
            if (name.equals(prof.getName())) {
                return count - 1;
            }
        }
        return -1;
    }

    public void printProfs() {
        System.out.println(("Type in what profile you want to access"));
        for (Profile prof : profileList) {
            System.out.println(prof.getName());
        }
    }

    //REQUIRES: prof is in the list
    //returns profile in the position of i
    public Profile get(int i) {
        return (profileList.get(i));
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("ListOfProfiles", name);
        json.put("profiles", profilesToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray profilesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Profile p : profileList) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }

}