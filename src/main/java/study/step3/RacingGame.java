package study.step3;

import study.step3.dto.Car;
import study.step3.dto.RacingInput;
import study.step3.move.MoveStrategy;
import study.step3.move.RandomlyMoveStrategy;

import java.util.*;

public class RacingGame {

    private final List<Car> carList = new ArrayList<>();
    private final MoveStrategy moveStrategy;

    public RacingGame(int carNum, MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        for (int i = 0; i < carNum; i++) {
            this.carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }


    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingInput input = inputView.enter();

        RacingGame racingGame = new RacingGame(input.getCarNum(), new RandomlyMoveStrategy());

        for (int i = 0; i < input.getTryNum(); i++) {
            racingGame.play();
            List<Car> cars = racingGame.getCarList();
            System.out.println("\n실행 결과");
            resultView.printCars(cars);
        }


    }

    public void play() {
        for (Car car : carList) {
            if (moveStrategy.isSuccess()) {
                car.move();
            }
        }
    }
}
