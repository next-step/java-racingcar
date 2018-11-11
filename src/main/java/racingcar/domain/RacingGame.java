package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int MOVECHECK_NUM = 4;

    private List<Car> cars;
    private int time;

    public RacingGame(String[] carNames, int time){
        this.cars = new ArrayList<>();
        for(String carName : carNames){
            this.cars.add(new Car(carName));
        }
        this.time = time;
    }

    public List<Car> getCars() { return this.cars; }
    public int getTime() { return  this.time; }

    public static void main(String[] args){
        InputView in = new InputView();
        in.inputSetting();
        RacingGame game = new RacingGame(in.getCarNames(), in.getTime());
        CarCollection carCollection = new CarCollection(game.cars);

        for(int i = 0; i < game.time; i++){
            ResultView.result(game.move());
        }
        ResultView.printWinner(carCollection.decideWinner(game.cars));

    }

    public List<Car> move(){
        moveProcessByTime(cars);
        return cars;
    }

    public static void moveProcessByTime(List<Car> car){
        int idx = 0;
        for (Car selectedCar : car) {
            movePerCarProcess(car, idx++);
        }
    }

    public static void movePerCarProcess(List<Car> car, int idx){
        if (movePossibleCheck()) {
            car.get(idx).moveOnePoint();
        }
    }

    public static boolean movePossibleCheck(){
        int randomNum = new Random().nextInt(10);
        return randomNum >= MOVECHECK_NUM;
    }

}
