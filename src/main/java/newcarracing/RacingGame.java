package newcarracing;

import java.util.*;

public class RacingGame {
    private static final Random random = new Random();
    public static final int ZERO_TO_NINE = 10;

    private RacingGame() {}

    public static List<RacingCar> initRacingCars(String[] carNames) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new RacingCar(name));
        }
        return cars;
    }

    public static void racing(List<RacingCar> cars) {
        cars.forEach(RacingGame::moveOrStop);
    }

    private static void moveOrStop(RacingCar car) {
        if(canMove()) {
            car.moveForward();
        }
    }

    private static boolean canMove() {
        return random.nextInt(ZERO_TO_NINE) >= 4;
    }

    public static List<RacingCar> createWinnersList(List<RacingCar> cars) {
        List<RacingCar> winners = new ArrayList<>();
        int maxPosition = findMaxPosition(cars);
        for(RacingCar car : cars) {
            addWinnerAtMaxPosition(winners, maxPosition, car);
        }
        return winners;
    }

    private static void addWinnerAtMaxPosition(List<RacingCar> winners, int maxPosition, RacingCar car) {
        if(car.isMaxPosition(maxPosition)) {
            winners.add(car);
        }
    }

    private static int findMaxPosition(List<RacingCar> cars) {
        return cars.stream().max(RacingCar::compareTo).get().getPosition();
    }

    private static boolean isLastGame(int triedCount, int tryCount) {
        if(triedCount == tryCount) {
            return true;
        }
        return false;
    }
}
