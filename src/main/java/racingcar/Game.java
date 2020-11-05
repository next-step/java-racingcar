package racingcar;

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
        System.out.println(roundCount);
    }

    public static void setCars(int count){
        cars = new Car[count];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
    }

    public static void playRound(){
        for (int i = 0; i < cars.length; i++) {
            randomFoward(cars[i]);
            DrawResult(cars[i]);
            ResultView.drawLineBreak();
        }
        ResultView.drawLineBreak();
    }

    public static void randomFoward(Car car){
        if(random.nextInt(10) >= 4) {
            car.foward();
        }
    }

    public static void DrawResult(Car car){
        for (int i = 0; i < car.getTravelDistance(); i++) {
            ResultView.drawTravelDistance();
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
