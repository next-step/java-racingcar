package mission1.racing;

import mission1.racing.model.Car;
import mission1.racing.view.RacingGameOutputView;

import java.util.ArrayList;

public class Movement {
    private ArrayList<Car> cars = new ArrayList<>();
    private final int LIMIT = 4;

    private RacingGameOutputView outputView = new RacingGameOutputView();
    private RacingRandom random = new RacingRandom();

    public Movement() {};
    public Movement(int carNumber) {
        for(int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
    }

    public void move() {
        for(int i = 0; i < cars.size(); i++) {
            moveCondition(random.random(), i);
            outputView.resultView(cars.get(i).name, cars.get(i).carPositions);
        }

        System.out.println();
    }

    public void moveCondition(int randomValue, int index) {
        if (randomValue >= LIMIT) {
            cars.get(index).go();
        }
    }
}
