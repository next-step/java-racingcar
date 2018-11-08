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

        for(int i = 0; i < game.time; i++){
            ResultView.result(game.move());
        }
        ResultView.printWinner(Car.decideWinner(game.car));
    }

    public ArrayList<Car> move(){
        moveProcessByTime(car);
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
            car.get(idx).moveOnePoint();
        }
    }

    public static boolean movePossibleCheck(){
        int randomNum = new Random().nextInt(10);
        return randomNum >= MOVECHECK_NUM;
    }

}
