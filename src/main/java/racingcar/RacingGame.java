package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    private Car[] car;
    private int time;
    private static final int MOVECHECK_NUM = 4;

    public RacingGame(Car[] car, int time){
        this.car = car;
        this.time = time;
    }

    public static void main(String[] args){
        InputView in = new InputView();
        in.inputSetting();
        RacingGame game = new RacingGame(in.getCar(), in.getTime());

        game.move();
        game.decideWinner();
    }

    public Car[] move(){
        for(int i = 0; i < time; i++){
            moveProcessByTime(car);
            printCarPosition(car);
        }
        return car;
    }

    public static void moveProcessByTime(Car[] car){
        int idx = 0;
        for (Car selectedCar : car) {
            movePerCarProcess(car, idx++);
        }
    }

    public static void movePerCarProcess(Car[] car, int idx){
        if (movePossibleCheck()) {
            car[idx].setPosition(car[idx].getPosition() + 1);
        }
    }

    public static boolean movePossibleCheck(){
        int randomNum = new Random().nextInt(10);
        return randomNum >= MOVECHECK_NUM;
    }

    public static void printCarPosition(Car[] car){
        ResultView.result(car);
    }

    public void decideWinner(){
        ArrayList<Car> winners = new ArrayList<Car>();
        int maxPosition = car[0].getPosition();
        for(int i = 1; i < car.length; i++){
            maxPosition = searchMaxPosition(maxPosition, car[i]);
        }

        for(Car selectedCar : car){
            checkPositionPerCar(maxPosition, selectedCar, winners);
        }

        ResultView.printWinner(winners);
    }

    public static int searchMaxPosition(int maxPosition, Car car){
        if(car.getPosition() >= maxPosition){
            return car.getPosition();
        }
        return maxPosition;
    }

    public static void checkPositionPerCar(int maxPosition, Car car, ArrayList<Car> winners){
        if(car.getPosition() == maxPosition){
            winners.add(car);
        }
    }

}
