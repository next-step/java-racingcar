package com.nextstep.javaRacing;

public class Position {
    private String what;
    private int position;

    public Position(String what){
        this.what = what;
        this.position = 0;
    }

    public void add(int distance) {
        this.position += distance;
    }

    public int now() {
        return position;
    }
}
