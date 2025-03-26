package racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarController {

    private List<Car> cars;
    private int numberOfOperations;
    private MovingStrategy movingStrategy;
    private Random numberGenerator;

    public RacingCarController(int numberOfParticipants, int numberOfOperations) {
        this.cars = IntStream.range(0, numberOfParticipants)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
        this.numberOfOperations = numberOfOperations;
        this.movingStrategy = new MovingStrategy();
        this.numberGenerator = new Random();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getOperationCount() {
        return numberOfOperations;
    }

    public void run() {
        for (Car car: cars) {
            if (movingStrategy.isMoving(numberGenerator.nextInt(10))) {
                car.move();
            }
        }
    }

}
