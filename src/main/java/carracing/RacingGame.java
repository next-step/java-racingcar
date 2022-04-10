package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final Random random = new Random();
    public static final int ZERO_TO_NINE = 10;

    private RacingGame() {}

    public static List<RacingCar> initRacingCars(int countOfCars) {
        List<RacingCar> carList = new ArrayList<>();
        while (countOfCars-- > 0) {
            carList.add(new RacingCar());
        }
        return carList;
    }

    public static void racing(List<RacingCar> carList) {
        for (int i = 0; i < carList.size(); i++) {
            moveOrStop(carList.get(i));
        }
    }

    private static void moveOrStop(RacingCar car) {
        if(canMove()) {
            car.moveForward();
        }
    }

    private static boolean canMove() {
        return random.nextInt(ZERO_TO_NINE) >= 4;
    }
}
