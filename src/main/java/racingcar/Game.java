package racingcar;

import java.util.Random;

public class Game {
    private static int roundCount;
    private static Random random = new Random();

    public static Cars cars = new Cars();

    public static int getRoundCount(){
        return roundCount;
    }

    public static void setRoundCount(int roundCount){
        roundCount = roundCount;
    }

    public void setCars(int count){
            cars.createCars(count);
    }

    public static void playRound(){
        for (int i = 0; i < cars.getSize(); i++) {
            randomFoward(cars.getCar(i));
            drawResult(cars.getCar(i));
            ResultView.drawLineBreak();
        }
        ResultView.drawLineBreak();
    }

    public static void randomFoward(Car car){
        car.move(RandomGenerator.getRandomNumber());
    }

    public static void drawResult(Car car){
            ResultView.drawTravelDistance(car);
    }

    public void playGame(){

        InputView.viewCountCarInput();
        InputView.viewCountRoundInput();

        ResultView.viewResultMessage();

        for (int i = 0; i < roundCount; i++) {
            playRound();
        }
    }
}
