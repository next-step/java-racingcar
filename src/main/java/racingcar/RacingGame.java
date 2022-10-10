package racingcar;

import racingcar.domain.Cars;
import racingcar.condition.RandomMoveCondition;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        List<String> nameOfCars = Input.nameOfCars();
        int numberOfAttempts = Input.numberOfAttempts();

        Cars cars = new Cars(nameOfCars, numberOfAttempts, new RandomMoveCondition());
        while(cars.isRacing()) {
            cars.race();
            Output.resultString(cars.getCars());
        }
        Output.resultRacingString(cars.getWinners());
    }
}
