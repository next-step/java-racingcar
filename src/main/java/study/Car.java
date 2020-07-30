package study;

import java.util.Random;

class Car {

    private static final Random PICKER = new Random();

    private int position;

    void move() {
        position += (PICKER.nextInt() >= 4) ? 1 : 0;
    }

    int getPosition() {
        return position;
    }

}
