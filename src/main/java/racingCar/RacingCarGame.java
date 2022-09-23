package racingCar;

import racingCar.domain.Car;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.play();
    }

    public void play(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int numberOfCars = inputView.askHowMayCars();
        int numberOfTimes = inputView.askHowManyTimes();

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        outputView.printRacingResultTitle();

        for (int j = 0; j < numberOfTimes; j++) {
            cars.forEach(Car::race);
            outputView.showRacingResult(cars);
        }


    }
}
