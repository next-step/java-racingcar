package ch01.step2;

import java.util.Random;

public class RacingGame {

    void execute(){
        InputView iv = new InputView();

    }

    public int getRandomNumber(){
        return new Random().nextInt(10);
    }
    public static void main(String[] args) {
        new RacingGame().execute();
    }
}
