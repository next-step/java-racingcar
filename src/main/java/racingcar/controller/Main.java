package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String carNames = Input.inputCarsName();
        ArrayList<Car> carsList = Car.asCarsList(carNames);
        int stages = Input.inputStages();

        Racing racing = new Racing(carsList, stages);
        for(int current = stages; current > 0; --current){
            racing.race();
            Output.printCurrentCarsState(racing.getCarsList());
        }
        Output.printWinners(racing.getCarsList(), racing.getMaxDistance());
    }
}