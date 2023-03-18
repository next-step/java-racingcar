package raingcar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class RacingGame {
    private int rapCount;
    private ArrayList<RacingCar> cars;
    private Random engine;
    private RacingStatus displayRacing;
    public RacingGame (@NotNull String carNames) {
        String[] carName = carNames.split(",");
        cars = new ArrayList<RacingCar>();
        for (String name : carName) {
            cars.add(new RacingCar(name));
        }
        engine = new Random();
        displayRacing = new RacingStatus();
    }

    private void carsMove() {
        for (RacingCar car : cars)
            car.move(engine.nextInt(10));
    }
    public int play (int raps) {
        int rap;
        rapCount = raps;
        for (rap = 0; rap < rapCount; rap++) {
            carsMove();
            displayRacing.displayCars(cars);
        }
        return rap;
    }

    public ArrayList<RacingCar> getCars () {
        return cars;
    }

    public ArrayList<RacingCar> getWinner () {
        ArrayList<RacingCar> winner = new ArrayList<RacingCar>();
        int maxDistance = 0;
        for (RacingCar car : cars)
            if (maxDistance < car.getMoveDistance())
                maxDistance = car.getMoveDistance();
        for (RacingCar car : cars)
            if (maxDistance == car.getMoveDistance())
                winner.add(car);
        return winner;
    }
}
