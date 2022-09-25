package step3;


import java.util.Random;

public class Car {
    int pos;

    public Car() {
        this.pos = 0;
    }

    public void move(int num) {
        if (num >= 4) {
            this.pos++;
        }
    }

    public void play() {
        move(new RandomNumber().num);
    }

}
