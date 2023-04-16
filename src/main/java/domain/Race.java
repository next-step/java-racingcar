package domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    public static List<RacingCar> racingCarList = new ArrayList<>();

    public static void createCars(String[] nameList) {
        for (String name : nameList) {
            isNameValid(name);
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

    private static void isNameValid(String name) {
        if (!RacingCar.isNameValid(name)){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
