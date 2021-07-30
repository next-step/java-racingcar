package step3;

import java.util.Scanner;

public class Car {
    private int move;

    public Car() {
        this.move = 0;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void go(){
        this.move += 1;
    }
}
