package carRacing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingGame(String[] names) {
        checkNameSize(names);
        for (int i = 0; i < names.length; i++) {
            racingCars.add(new RacingCar(names[i]));
        }
    }

    public void playGame() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomUtil.getRandomValue());
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void checkNameSize(String[] names) {
        for (String name : names) {
            carNameSizeCheck(name);
        }
    }

    private void carNameSizeCheck(String name) {
        if (name.length() > 5) {
            throw new RuntimeException();
        }
    }
}
