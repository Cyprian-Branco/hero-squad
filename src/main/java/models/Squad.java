package models;

public class Squad {
    private String name;
    private String cause;
    private int max_size;

    public Squad(String name, String cause, int max_size){
        this.name = name;
        this.cause = cause;
        this.max_size = max_size;
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

}
