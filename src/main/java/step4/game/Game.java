package step4.game;

import step4.input.InputView;
import step4.input.UserInput;
import step4.racingcar.RacingCar;
import step4.random.RandomValueGenerator;
import step4.result.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void start() {
        //inputView
        final UserInput userInput = InputView.input();

        List<RacingCar> cars = makeCars(userInput.getCarNames());

        //resultView
        ResultView.printResultText();

        for (int i = 0; i < userInput.getTryNumber(); i++) {
            tryMove(cars);
            ResultView.printTryResult(cars);
        }

        ResultView.printWinners(toNames(extractWinners(cars)));
    }

    private static List<RacingCar> makeCars(final String[] carNames) {
        List<RacingCar> cars = new ArrayList<>();

        for (final String carName : carNames) {
            cars.add(new RacingCar(carName));
        }

        return cars;
    }

    private static void tryMove(final List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.moveIfInRange(RandomValueGenerator.generateRandomValueFromZeroToNine());
        }
    }

    public static List<RacingCar> extractWinners(final List<RacingCar> cars) {
        cars.sort(null);

        final RacingCar winner = cars.get(0);

        return filterCarsWithWinnerDistance(cars, winner.currentDistance());
    }

    private static List<RacingCar> filterCarsWithWinnerDistance(final List<RacingCar> cars, final int winnerDistance) {
        List<RacingCar> winnerCars = new ArrayList<>();

        for (final RacingCar car : cars) {
            if (isNotSameWinnerDistance(winnerDistance, car)) {
                break;
            }

            winnerCars.add(car);
        }

        return winnerCars;
    }

    private static boolean isNotSameWinnerDistance(final int winnerDistance, final RacingCar car) {
        return car.currentDistance() != winnerDistance;
    }

    public static String[] toNames(final List<RacingCar> winners) {
        String[] winnerNames = new String[winners.size()];

        for (int i = 0; i < winners.size(); i++) {
            final RacingCar winner = winners.get(i);

            winnerNames[i] = winner.carName();
        }

        return winnerNames;
    }
}
