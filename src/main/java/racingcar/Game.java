package racingcar;

import java.util.Random;

public class Game {
    private static int roundCount;
    private static Random random = new Random();

    public Cars cars = new Cars();

    public int getRoundCount(){
        return roundCount;
    }

    public static void setRoundCount(int roundCount){
        roundCount = roundCount;
    }

    public void setCars(int count){
            cars.createCars(count);
    }

    public void playRound(){
        for (int i = 0; i < cars.getSize(); i++) {
            randomFoward(cars.getCar(i));
            drawResult(cars.getCar(i));
            ResultView.drawLineBreak();
        }
        ResultView.drawLineBreak();
    }

    public static void randomFoward(Car car){
        if(random.nextInt(10) >= 4) {
            car.forward();
        }
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
