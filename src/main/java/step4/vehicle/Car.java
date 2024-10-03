package step4.vehicle;

import step4.util.NumberGenerator;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private int location = 1;
    private String name ;

    public Car(String name){
        checkNameLength(name);
        this.name = name;
    }

    public void move(NumberGenerator generator) {
        if (isMovable(generator.getValue())) {
            this.location++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION;
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    private static void checkNameLength(String name) {
        if(name.length()>5|| name.isEmpty())
            throw new IllegalArgumentException("길이가 1이상 5이하인 문자열이여야 함");
    }

}
