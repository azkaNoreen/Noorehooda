package com.example.noorehuda.assignment2;

public class RVListChapters {
    String Name;
    String EngName;
    int position;
    String Type;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEngName() {
        return EngName;
    }

    public void setEngName(String engName) {
        EngName = engName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public RVListChapters(String name, String engName, int position, String type) {
        Name = name;
        EngName = engName;
        this.position = position;
        Type = type;
    }
}
