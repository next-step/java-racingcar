package domain.service;

import domain.core.Car;
import domain.core.RacingCar;
import utils.InputCarName;
import utils.InputMove;
import utils.exception.CarNameAtLeastOneCommaWhenSplitException;
import utils.exception.CarNameExceedFiveCharacterException;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements Game {

    @Override
    public void run() {
        String[] carNames = inputCarName();
        RacingCar racingCar = initRacingCar(carNames);
        int move = inputMove();
        play(racingCar, move);
    }

    private void play(RacingCar racingCar, int move) {
        System.out.println();
        System.out.println("실행 결과");
        racingCar.playAll(move);
        racingCar.printWinner();
    }

    private RacingCar initRacingCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return new RacingCar(cars);
    }

    private int inputMove() {
        boolean isInput = true;
        int move = 0;
        while (isInput) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                move = InputMove.inMove(); // Exception 체크
                isInput = false;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        return move;
    }

    private String[] inputCarName() {
        boolean isInput = true;
        String[] carNames = null;
        while (isInput) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                carNames = InputCarName.inCarName(); // Exception 체크
                isInput = false;
            } catch (CarNameExceedFiveCharacterException | CarNameAtLeastOneCommaWhenSplitException e) {
                System.out.println(e.getMessage());
            }
        }

        return carNames;
    }
}
