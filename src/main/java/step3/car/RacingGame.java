package step3.car;

import step3.generator.GenerateNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int time;
    private final CarFactory carFactory;

    private RacingGame(int moveCount, CarFactory carFactory)  {
        validationCheck(moveCount);
        this.time = moveCount;
        this.carFactory = carFactory;
    }

    public List<int[]> start(GenerateNumberStrategy numberGenerator){
        List<int[]> carPositionList = new ArrayList<>();

        for (int i = 0; i < time; i++) {
            int[] positions = move(numberGenerator, carFactory.createCars());
            carPositionList.add(positions);
        }
        return carPositionList;
    }

    private int[] move(GenerateNumberStrategy numberGenerator, List<Car> cars) {
        int[] positions = new int[cars.size()];

        for (int j = 0; j < cars.size(); j++) {
            Car car = cars.get(j);
            car.move(numberGenerator);
            positions[j] = car.getPosition();
        }
        return positions;
    }

    public static RacingGame of(int moveCount, CarFactory carFactory){
        return new RacingGame(moveCount, carFactory);
    }

    private void validationCheck(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("시도 회수는 음수를 입력할 수 없습니다.");
        }
    }
}
