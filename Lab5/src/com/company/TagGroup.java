package com.company;

public class TagGroup {
    private String Name;
    private int count;

    public TagGroup(String name, int count) {
        this.Name = name;
        this.count = count;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return Name;
    }

    public int getCount() {
        return count;
    }
}
