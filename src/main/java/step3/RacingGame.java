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

        int motorRacingCount = InputView.setMotorRacingCount(scanner);

        ResultView.gameResult();

        play(carInfoMap, motorRacingCount);

        int maxPosition = Winners.findMaxPosition(carInfoMap);
        List<String> winners = Winners.findWinners(carInfoMap, maxPosition);
        String winnerMember = ResultView.printWinner(winners);
        System.out.println(winnerMember);
    }

    private static void play(Map<String, Car> carInfoMap, int motorRacingCount) {
        for (int i = GAME_START_NUMBER; i <= motorRacingCount; i++) {
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
            System.out.println(ResultView.printCarMileAge(car, mileAge));
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
