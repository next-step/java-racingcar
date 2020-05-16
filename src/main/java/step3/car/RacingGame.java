package step3.car;

import step3.generator.GenerateNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int time;
    private final int numOfCar;

    private RacingGame(int moveCount, int numOfCar)  {
        validationCheck(moveCount, numOfCar);
        this.time = moveCount;
        this.numOfCar = numOfCar;
    }

    public List<int[]> start(GenerateNumberStrategy numberGenerator){
        List<int[]> carPositionList = new ArrayList<>();
        List<Car> cars = CarFactory.createCars(numOfCar);

        for (int i = 0; i < time; i++) {
            int[] positions = move(numberGenerator, cars);
            carPositionList.add(positions);
        }
        return carPositionList;
    }

    private int[] move(GenerateNumberStrategy numberGenerator, List<Car> cars) {
        int[] positions = new int[cars.size()];

        for (int j = 0; j < cars.size(); j++) {
            Car car = cars.get(j);
            positions[j] = car.move(numberGenerator);
        }
        return positions;
    }

    public static RacingGame of(int moveCount, int numOfCar){
        return new RacingGame(moveCount, numOfCar);
    }

    private void validationCheck(int moveCount, int numberOfCars) {
        if (moveCount < 1) {
            throw new IllegalArgumentException("시도 회수는 1보다 작은 수를 입력할 수 없습니다.");
        }

        if (numberOfCars < 1) {
            throw new IllegalArgumentException("자동차 대수는 1보다 작은 수를 입력할 수 없습니다.");
        }
    }
}
