package racing.view;

import racing.*;
import racing.exception.CarsNullPointerException;
import racing.exception.RacingNullPointerException;

import java.util.HashMap;
import java.util.Map;

public class ResultView {
    private static final String RESULT_INTRODUCE_MESSAGE = "실행 결과";

    public static void print(RacingGame racingGame, RacingCars racingCars, RacingGameManagement carDrivingStatus) {
        validateObjectsNull(racingGame, racingCars);

        System.out.println(RESULT_INTRODUCE_MESSAGE);
        drawRacingResult(racingGame, racingCars, carDrivingStatus);
        System.out.println(carDrivingStatus.findWinners());
    }

    private static void validateObjectsNull(RacingGame racingGame, RacingCars racingCars) {
        if (racingGame == null) {
            throw new RacingNullPointerException();
        }

        if (racingCars == null) {
            throw new CarsNullPointerException();
        }
    }

    private static void drawRacingResult(RacingGame racingGame, RacingCars racingCars, RacingGameManagement carDrivingStatus) {
        RacingViewRepository racingViewRepository = initRacingResult(racingCars);
        for (int attemptsNumber = 0; attemptsNumber < racingGame.getAttemptsCount(); attemptsNumber++) {
            drawCars(racingCars, racingViewRepository, attemptsNumber, carDrivingStatus);
        }
    }

    private static RacingViewRepository initRacingResult(RacingCars racingCars) {
        Map<String, StringBuilder> result = new HashMap<>();
        racingCars.stream().forEach(car -> result.put(car.getCarName(), new StringBuilder()));

        return new RacingViewRepository(result);
    }

    private static void drawCars(RacingCars racingCars, RacingViewRepository racingViewRepository, int attemptsNumber, RacingGameManagement racingGameManagement) {
        for (Car car : racingCars) {
            String carName = car.getCarName();
            CarDrivingType carDriving = racingGameManagement.findDrivingTypes(car).getCarDrivingType(attemptsNumber);
            addCarString(racingViewRepository, carDriving, carName);
            racingViewRepository.print(carName);
        }

        System.out.println();
    }

    private static void addCarString(RacingViewRepository racingViewRepository, CarDrivingType carDriving, String carName) {
        if (carDriving == CarDrivingType.STOP) {
            return;
        }

        racingViewRepository.add(carName);
    }
}
