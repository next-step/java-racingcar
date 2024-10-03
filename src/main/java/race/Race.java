package race;

import java.util.*;

public class Race {
    public static final int RANDOM_UPPER_LIMIT = 10;
    private static final int MIN_CAR_COUNT = 2;
    private static final int MIN_GAME_COUNT = 1;
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void start() {
        RaceInput raceInput = getRaceInput();
        List<RacingCar> cars = initiateCars(raceInput.carNames());

        ResultView.printResultTitle();
        for (int gameCount = 0; gameCount < raceInput.gameCount(); gameCount++) {
            runStopOrGoRound(cars);
        }
    }

    private static RaceInput getRaceInput() {
        List<String> parsedCarNames = getCarNamesInput();
        int gameCount = getGameCountInput();

        return new RaceInput(gameCount, parsedCarNames);
    }

    private static int getGameCountInput() {
        int gameCount = 0;

        while (gameCount < MIN_GAME_COUNT) {
            gameCount = InputView.inputGameCount();
        }

        return gameCount;
    }

    private static List<String> getCarNamesInput() {
        List<String> parsedCarNames = new ArrayList<>();
        String carNames = "";

        while (carNames.isBlank() || !isValidCarNames(parsedCarNames)) {
            carNames = InputView.inputCarName();
            parsedCarNames = parseCarNames(carNames);
        }

        return parsedCarNames;
    }

    private static List<String> parseCarNames(String carNames) {
        if (carNames.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }

    private static boolean isValidCarNames(List<String> parsedCarNames) {
        if (parsedCarNames.size() < MIN_CAR_COUNT) {
            return false;
        }

        for (String parsedCarName : parsedCarNames) {
            if (!isValidCarName(parsedCarName)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidCarName(String carName) {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    public static List<RacingCar> initiateCars(List<String> carNames) {
        List<RacingCar> cars = new ArrayList<>();

        for (String carName : carNames) {
            RacingCar car = new RacingCar(carName);
            cars.add(car);
        }

        return cars;
    }

    private static void runStopOrGoRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            int generatedRandom = generateIntBetween0and9();
            car.moveCarForwardIfCanGo(generatedRandom);
        }
        ResultView.printCarStates(cars);
    }

    private static int generateIntBetween0and9() {
        return new Random().nextInt(RANDOM_UPPER_LIMIT);
    }
}
