package racingcar;

import java.util.Random;

public class Game {
    private static int roundCount;
    private static Car[] cars;
    private static Random random = new Random();

    public static void setGameCount(int count){
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
}
