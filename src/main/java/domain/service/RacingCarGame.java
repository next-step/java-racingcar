package domain.service;

import domain.core.Car;
import domain.core.CarName;
import domain.core.RacingCars;
import domain.core.exception.CarNameExceedFiveCharacterException;
import utils.InputCarNames;
import utils.InputMove;
import utils.exception.CarNameAtLeastOneCommaWhenSplitException;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements Game {

    @Override
    public void run() {
        List<Car> cars = inputCars();
        RacingCars racingCars = new RacingCars(cars);
        int move = inputMove();
        play(racingCars, move);
    }

    private List<Car> inputCars() {
        List<Car> cars = new ArrayList<>();
        boolean isInput = true;
        while (isInput) {
            try {
                String[] carNames = inputCarNames();
                cars = generateCars(carNames);
                isInput = false;
            } catch (CarNameAtLeastOneCommaWhenSplitException | CarNameExceedFiveCharacterException e) {
                System.out.println(e.getMessage());
            }
        }
        return cars;
    }

    private String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return InputCarNames.inCarName(); // Exception 체크
    }

    private List<Car> generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(new CarName(carName));
            cars.add(car);
        }
        return cars;
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

    private void play(RacingCars racingCars, int move) {
        System.out.println();
        System.out.println("실행 결과");
        racingCars.moveAll(move);
        racingCars.printWinner();
    }
}
