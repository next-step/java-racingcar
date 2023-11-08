package carracing;

import carracing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

import static carracing.GameWinner.carRaceTopPosition;
import static carracing.ui.ResultView.carRacingWinnersView;
import static carracing.util.InputValueValidate.splitCommaInputCarName;
import static carracing.util.InputValueValidate.verifyExceedFiveCarName;

public class RacingGame {

    private final List<Car> carList;
    private final int trialCount;
    private final RandomNumberGenerator random = new RandomNumberGenerator();

    public RacingGame(String carName, int trialCount) {
        this.carList = cars(carName);
        this.trialCount = negativeNumberCheck(trialCount);
    }

    public void gameStart() {
        for (int i = 0; i < trialCount; i++) {
            racingGameProcess();
            System.out.println();
        }
        carRacingWinnersView(carList);
    }

    private List<Car> cars(String carName) {
        return makeCarList(carName);
    }

    private void racingGameProcess() {
        for (Car car : carList) {
            printResultRaceGameProcess(car);
            car.move(random.getRandomNumber());
            carRaceTopPosition(car);
        }
    }

    private static List<Car> makeCarList(String carName) {
        String[] names = splitCommaInputCarName(carName);
        checkExceedFiveCarName(names);

        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    private static void checkExceedFiveCarName(String[] names) {
        for (String name : names) {
            verifyExceedFiveCarName(name);
        }
    }

    private static int negativeNumberCheck(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private static void printResultRaceGameProcess(Car car) {
        String nameAndPositionView = ResultView.createNameAndPositionView(car.getName(), car.getPosition());
        System.out.println(nameAndPositionView);
    }

}
