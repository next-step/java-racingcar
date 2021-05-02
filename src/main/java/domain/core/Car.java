package domain.core;

import utils.RandomNumber;

public class Car {
    public static final int GO_CONDITION = 4;
    public static final String GO_STRING = "-";
    private final String name;
    private int goCount;

    public Car(String name) {
        this.name = name;
        this.goCount = 0;
    }

    public void play() {
        if (RandomNumber.generateNumber() >= GO_CONDITION) {
            this.goCount++;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getGoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < goCount; i++) {
            sb.append(GO_STRING);
        }

        return sb.toString();
    }

    public int getGoCount(){
        return this.goCount;
    }
}
