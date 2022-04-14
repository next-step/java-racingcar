package racing.view;

import racing.Car;
import racing.CarDriving;
import racing.Racing;
import racing.RacingGameManagement;
import racing.exception.CarsNullPointerException;
import racing.exception.RacingNullPointerException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ResultView {
    public static final String RESULT_INTRODUCE_MESSAGE = "실행 결과";

    public static void draw(Racing racing, List<Car> cars, RacingGameManagement carDrivingStatus) {
        checkObjectsNull(racing, cars);
        System.out.println(RESULT_INTRODUCE_MESSAGE);
        drawRacingResult(racing, cars, carDrivingStatus);
    }

    private static void checkObjectsNull(Racing racing, List<Car> cars) {
        if (racing == null) {
            throw new RacingNullPointerException();
        }

        if (cars == null) {
            throw new CarsNullPointerException();
        }
    }

    private static void drawRacingResult(Racing racing, List<Car> cars, RacingGameManagement carDrivingStatus) {
        List<StringBuilder> result = initRacingResult(racing.getAttemptsCount());
        for (int i = 0; i < racing.getAttemptsCount(); i++) {
            drawCars(cars, result, i, carDrivingStatus);
        }
    }

    private static List<StringBuilder> initRacingResult(int attemptsCount) {
        List<StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < attemptsCount; i++) {
            result.add(new StringBuilder());
        }
        return result;
    }

    private static void drawCars(List<Car> cars, List<StringBuilder> result, int i, RacingGameManagement carDrivingStatus) {
        for (int j = 0; j < cars.size(); j++) {
            UUID carId = cars.get(j).getId();
            CarDriving carDriving = carDrivingStatus.getStatus(carId).get(i);

            addCarString(result.get(j), carDriving);
            System.out.println(result.get(j));
        }

        System.out.println();
    }

    private static void addCarString(StringBuilder j, CarDriving carDriving) {
        if (carDriving == CarDriving.STOP) {
            return;
        }

        j.append("-");
    }
}
