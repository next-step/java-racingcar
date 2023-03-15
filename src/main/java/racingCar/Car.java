package racingCar;

import java.util.Random;

public class Car {

    private final int MOVABLE_MIN_NUMBER = 4;
    private final int DRAW_RANGE = 9;
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int i = draw();
        if(i >= MOVABLE_MIN_NUMBER) {
            this.position++;
        }
    }

    private int draw() {
        Random ran = new Random();
        return ran.nextInt(DRAW_RANGE);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


    public void showPosition() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}