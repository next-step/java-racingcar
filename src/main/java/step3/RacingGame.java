package step3;

import step3.domain.Car;
import step3.domain.RacingCar;
import step3.domain.Winners;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.*;

public class RacingGame {

    private static final String CAR_DELIMITER = ",";
    private static final int GAME_START_NUMBER = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String participatingCar = InputView.setRacingCarNumber(scanner);
        String[] participatedCar = checkParticipatedCars(participatingCar);
        Map<String, Car> carInfoMap = preparationForGame(participatedCar);

        int racingCount = InputView.setMotorRacingCount(scanner);

        ResultView.gameResult();

        play(carInfoMap, racingCount);

        int positionMax = Winners.findMaxPosition(carInfoMap);
        List<String> winners = Winners.findWinners(carInfoMap, positionMax);
        String winnerMembers = ResultView.printWinners(winners);
        System.out.println(winnerMembers);
    }

    private static void play(Map<String, Car> carInfoMap, int racingCount) {
        for (int i = GAME_START_NUMBER; i <= racingCount; i++) {
            Set<String> keys = carInfoMap.keySet();
            race(carInfoMap, keys);
            System.out.println();
        }
    }

    private static void race(Map<String, Car> carInfoMap, Set<String> keys) {
        for (String carName : keys) {
            Car car = carInfoMap.get(carName);
            int carPosition = car.getPosition();

            carPosition = RacingCar.raceStart(carInfoMap, car.getCarName(), carPosition);

            car = new RacingCar(car.getCarName(), carPosition);
            carInfoMap.put(car.getCarName(), car);

            String mileAge = ResultView.printMovement(carPosition);
            System.out.println(ResultView.printMileAgeCar(car, mileAge));
        }
    }

    private static String[] checkParticipatedCars(String racingCarNames) {
        return racingCarNames.split(CAR_DELIMITER);
    }

    public static Map<String, Car> preparationForGame(String[] participatedCar) {
        Map<String, Car> carInfoMap = new HashMap<>();

        Arrays.stream(participatedCar)
                .map(RacingCar::new)
                .forEach(car -> carInfoMap.put(car.getCarName(), car));
        return carInfoMap;
    }

}
