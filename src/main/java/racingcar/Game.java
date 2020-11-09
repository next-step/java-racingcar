package racingcar;

import java.util.Random;

public class Game {
    private static int roundCount;
    private static Random random = new Random();

    private Cars cars = new Cars();


    public static void setRoundCount(int count){
        roundCount = count;
    }

    public void setCars(int count){

        for (int i = 0; i < count; i++) {
            cars.createCar();
        }
    }

    public void playRound(){
        for (int i = 0; i < cars.getSize(); i++) {
            randomFoward(cars.getCar(i));
            DrawResult(cars.getCar(i));
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

    public void playGame(){

        Admin admin = new Admin();

        InputView.viewCountCarInputMessage();
        admin.InputCarCount();

        InputView.viewCoutRoundInputMessage();
        admin.InputRoundCount();

        ResultView.viewResultMessage();

        for (int i = 0; i < roundCount; i++) {
            playRound();
        }
    }
}
