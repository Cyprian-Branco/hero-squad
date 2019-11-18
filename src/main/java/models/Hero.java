package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {
    private String name;
    private int age;
    private String specialPower;
    private String weakness;
    public static ArrayList<Hero> instances = new ArrayList<>();
    private int id;
    private int squadId;

    public Hero(String name,int age, String specialPower, String weakness, int squadId){
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.squadId = squadId;
        instances.add(this);
        this.id = instances.size();
        addHeroToSquad(squadId);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getSquadId() {
        return squadId;
    }
    public static ArrayList<Hero> getInstances() {
        return instances;
    }
    public void addHeroToSquad(int squadID){
        for(Squad squad:Squad.getInstances()){
            if(squad.getId() == squadID){
                squad.addMember(this);
                break;
            }
        }
    }
}
