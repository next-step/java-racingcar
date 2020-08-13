package step3;

import step3.domain.Car;
import step3.domain.RacingCar;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RacingGame {

    public static final int GAME_START_NUMBER = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String racingCarName = InputView.setRacingCarNumber(scanner);
        Map<String, Car> carInfoMap = RacingCar.preparationForGame(racingCarName);

        int motorRacingCount = InputView.setMotorRacingCount(scanner);

        ResultView.gameResult();

        play(carInfoMap, motorRacingCount);

        int maxPosition = RacingCar.findMaxPosition(carInfoMap);
        String winnerMmeber = ResultView.printWinner(carInfoMap, maxPosition);
        System.out.println(winnerMmeber);
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
            System.out.println(car.getCarName() + " : " + mileAge);
        }
    }

}
