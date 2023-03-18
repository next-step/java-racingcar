package raingcar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RacingGame {
    private final int rapCount;
    private ArrayList<RacingCar> cars;
    public RacingGame (@NotNull String carNames, int raps) {
        String[] carName = carNames.split(",");
        cars = new ArrayList<RacingCar>();
        for (String name : carName) {
            cars.add(new RacingCar(name));
        }
        rapCount = raps;
    }

    private void carsMove() {
        for (RacingCar car : cars)
            car.move(0);
    }
    public int play () {
        int rap;
        for (rap = 0; rap < rapCount; rap++)
            carsMove();
        return rap;
    }

    public ArrayList<RacingCar> getCars () {
        return cars;
    }
}
