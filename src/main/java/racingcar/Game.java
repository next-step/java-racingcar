package racingcar;

import jdk.internal.util.xml.impl.Input;

import java.util.Random;

public class Game {
    private static int roundCount;
    private static Car[] cars;
    private static Random random = new Random();

    public static void setRoundCount(int count){
        roundCount = count;
    }

    public static void setCars(int count){
        cars = new Car[count];
    }

    public static void playRound(){
        for (int i = 0; i < cars.length; i++) {
            if(random.nextInt(10) >= 4) cars[i].foward();
        }
    }

    public static void playGame(){
        InputView.viewCountCarInputMessage();
        User.InputCarCount();

        InputView.viewConutGameInputMessage();
        User.InputRoundCount();
    }
}
