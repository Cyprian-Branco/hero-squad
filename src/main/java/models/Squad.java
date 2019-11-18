package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String name;
    private String cause;
    private int max_size;

    private List<Hero> squadMembers = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;

    public Squad(String name, String cause, int max_size){
        this.name = name;
        this.cause = cause;
        this.max_size = max_size;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }

    public int getMax_size() {
        return max_size;
    }

    public int getId() {
        return id;
    }

    public static ArrayList<Squad>  getInstances() {
        return instances;
    }
    public String getSquadMembers(){
        return String.valueOf(squadMembers);
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }

    public void addMember(Hero hero) {
        squadMembers.add(hero);
    }
    public void update(String name, String cause, int max_size){
        this.name = name;
        this.cause = cause;
        this.max_size = max_size;
    }
    public void deleteSquad() {
        instances.remove(id-1);
    }

}
