package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceInfo;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();

        inputView.numberOfCarQuestionShow();
        int numberOfCar = Integer.parseInt(scanner.nextLine());

        inputView.raceTrialCountQuestionShow();
        int raceTrialCount = Integer.parseInt(scanner.nextLine());

        RaceInfo raceInfo = new RaceInfo(numberOfCar, raceTrialCount);

        List<Car> racingCars = new ArrayList<Car>();

        for (int i = 0; i < raceInfo.numberOfCar; i++) {
            racingCars.add(new Car());
        }
        Cars cars = new Cars(racingCars);

        cars.movable();

        System.out.println(cars.getCarsPositions());

    }
}
