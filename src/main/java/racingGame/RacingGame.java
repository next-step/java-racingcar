package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int MAXIMUM_BOUND = 10;
    private static final int MINIMUM_MOVABLE_SCORE = 4;

    private int move;
    private List<Car> carList;


    public void move() {
        for (Car car : carList) {
            if (canMove()) {
                car.moveForward();
            }
        }

        move--;
    }

    public void initialize(int cars, int move) {
        initializeMove(move);
        initializeCars(cars);
    }

    public boolean hasNextRound() {
        return move > 0;
    }

    public List<Car> getCarsInGame() {
        return carList;
    }

    private void initializeMove(int move) {
        this.move = move;
    }

    private void initializeCars(int cars) {
        carList = new ArrayList<>();
        for (int i = 0; i < cars; i++) {
            carList.add(new Car());
        }
    }

    private boolean canMove() {
        Random random = new Random();
        return random.nextInt(MAXIMUM_BOUND) >= MINIMUM_MOVABLE_SCORE;
    }
}
