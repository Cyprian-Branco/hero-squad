package models;

import java.util.ArrayList;

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
    }
}
