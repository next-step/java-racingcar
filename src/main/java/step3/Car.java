package step3;

import java.util.Scanner;

public class Car {
    private int play;
    private int move;

    public Car(int play) {
        this.play = play;
        this.move = 0;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
