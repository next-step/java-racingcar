package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    private static final int MOVECHECK_NUM = 4;

    private ArrayList<Car> car;
    private int time;

    public RacingGame(String[] carNames, int time){
        this.car = new ArrayList<Car>();
        for(String carName : carNames){
            this.car.add(new Car(carName));
        }
        this.time = time;
    }

    public static void main(String[] args){
        InputView in = new InputView();
        in.inputSetting();
        RacingGame game = new RacingGame(in.getCarNames(), in.getTime());

        ResultView.result(game.move());
        ResultView.printWinner(game.decideWinner());
    }

    public ArrayList<Car> move(){
        for(int i = 0; i < time; i++){
            moveProcessByTime(car);
        }
        return car;
    }

    public static void moveProcessByTime(ArrayList<Car> car){
        int idx = 0;
        for (Car selectedCar : car) {
            movePerCarProcess(car, idx++);
        }
    }

    public static void movePerCarProcess(ArrayList<Car> car, int idx){
        if (movePossibleCheck()) {
            car.get(idx).move();
        }
    }

    public static boolean movePossibleCheck(){
        int randomNum = new Random().nextInt(10);
        return randomNum >= MOVECHECK_NUM;
    }

    public ArrayList<Car> decideWinner(){
        ArrayList<Car> winners = new ArrayList<Car>();
        int maxPosition = car.get(0).getPosition();
        for(Car selectedCar : car){
            maxPosition = searchMaxPosition(maxPosition, selectedCar);
        }

        for(Car selectedCar : car){
            checkPositionPerCar(maxPosition, selectedCar, winners);
        }

        return winners;
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
