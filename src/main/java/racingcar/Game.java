package racingcar;

import jdk.internal.util.xml.impl.Input;

import javax.xml.transform.Result;
import java.util.Random;

public class Game {
    private static int roundCount;
    private static Car[] cars;
    private static Random random = new Random();

    public static int getRoundCount(){
        return roundCount;
    }

    public static int getCarCount(){
        return cars.length;
    }

    public static void setRoundCount(int count){
        roundCount = count;
    }

    public static void setCars(int count){
        cars = new Car[count];
    }

    public static void playRound(){
        for (int i = 0; i < cars.length; i++) {
            randomFoward(cars[i]);
            applyResult(cars[i]);
        }
    }

    public static void randomFoward(Car car){
        if(random.nextInt(10) >= 4) car.foward();
    }

    public static void applyResult(Car car){
        for (int i = 0; i < car.getScore(); i++) {
            ResultView.viewTravelDistance();
        }
    }

    public static void playGame(){
        InputView.viewCountCarInputMessage();
        User.InputCarCount();

        InputView.viewCoutRoundInputMessage();
        User.InputRoundCount();

        ResultView.viewResultMessage();

        for (int i = 0; i < roundCount; i++) {
            playRound();
        }
    }
}
