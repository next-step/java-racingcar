package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int MAXIMUM_BOUND = 10;

    private int move;
    private List<Car> cars;

    public RacingGame(String carNames, int move) {
        initializeCars(carNames);
        initializeMove(move);
    }

    public void move() {
        for (Car car : cars) {
            car.moveForward(generateMoveScore());
        }

        move--;
    }

    public boolean hasNextRound() {
        return move > 0;
    }

    public List<Car> getCarsInGame() {
        return cars;
    }

    private void initializeMove(int move) {
        this.move = move;
    }

    private void initializeCars(String carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            this.cars.add(new Car(carName));
        }
    }

    private int generateMoveScore() {
        Random random = new Random();
        return random.nextInt(MAXIMUM_BOUND);
    }
}
