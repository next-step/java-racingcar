package racingGame;

import java.util.List;
import java.util.Vector;

public class Cars {

    private final List<Car> cars;

    private Cars(int numCar) {
        cars = new Vector<>();
        for (int i = 0; i < numCar; i++) {
            cars.add(new Car());
        }
    }

    public static Cars of(int numCar) {
        return new Cars(numCar);
    }

    public void moves(ScoreGenerator scoreGenerator) {
        for (Car car : cars) {
            car.move(scoreGenerator.generateScore());
        }
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new Vector<>(cars.size());

        for (int i = 0; i < cars.size(); i++) {
            positions.add(i, cars.get(i).getPosition());
        }

        return positions;
    }


}
