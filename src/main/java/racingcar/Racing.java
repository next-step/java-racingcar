package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    private static final int MINIMUM_DISTANCE_MOVE = 4;
    private static final int MAXIMUM_DISTANCE_MOVE = 9;

    private final ArrayList<Car> carsList;
    private final int stages;
    private final Random random;

    public Racing(ArrayList<Car> carsList, int stages){
        this.carsList = carsList;
        this.stages = stages;
        this.random = new Random();
    }

    public void start(){
        for(int current = stages; current > 0; --current){
            moveCars();
            InputOutput.printCurrentCarsState(this.carsList);
        }
        InputOutput.printWinners(this.carsList, getMaxDistance());
    }

    public void moveCars() {
        for(Car car : this.carsList){
            decideMove(car);
        }
    }

    public void decideMove(Car car) {
        if(getRandomNumber() >= MINIMUM_DISTANCE_MOVE){
            car.moveForward();
        }
    }

    public int getRandomNumber() {
        return this.random.nextInt(MAXIMUM_DISTANCE_MOVE + 1);
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for(Car car : this.carsList) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }
}
