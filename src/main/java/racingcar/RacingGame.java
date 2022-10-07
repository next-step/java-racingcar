package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomMoveCondition;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Racing {
    public static void main(String[] args) {
        List<String> nameOfCars = Input.nameOfCars();
        int numberOfAttempts = Input.numberOfAttempts();

        Cars cars = new Cars(nameOfCars, numberOfAttempts, new RandomMoveCondition());
        while(cars.racing()) {
            cars.race();
            //Output.resultString(cars.getCars());
        }
        //Output.resultString(cars.getWinners());
    }
}
