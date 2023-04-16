package domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    public static List<RacingCar> racingCarList = new ArrayList<>();

    public static void createCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            RacingCar car = new RacingCar();
            racingCarList.add(car);
        }
    }

    public static void race() {
        for (RacingCar racingCar : racingCarList) {
            boolean coin = CarNavigator.flipCoin(CarNavigator.getRandomNumber());
            racingCar.moveOrStop(coin);
        }
    }

    public static String[] getEachResult() {
        String[] result = new String[racingCarList.size()];
        for (int i = 0; i < racingCarList.size(); i++) {
            result[i] = "-".repeat(racingCarList.get(i).getDistance());
        }
        return result;
    }

    public static List<String[]> playRace(int[] input) {
        int carCount = input[0];
        int round = input[1];
        List<String[]> totalResult = new ArrayList<>();
        Race.createCar(carCount);
        for (int i = 0; i < round; i++) {
            Race.race();
            totalResult.add(getEachResult());
        }
        return totalResult;
    }
}
