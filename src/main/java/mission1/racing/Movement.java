package mission1.racing;

import mission1.racing.model.Car;
import mission1.racing.view.RacingGameOutputView;

import java.util.ArrayList;

public class Movement {
    public ArrayList<String> winners = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();
    private final int LIMIT = 4;
    private int maxPosition = 0;

    private RacingGameOutputView outputView = new RacingGameOutputView();
    private RacingRandom random = new RacingRandom();

    public Movement() {};
    public Movement(String[] inputCars) {
        for (String inputCar : inputCars) {
            this.cars.add(new Car(inputCar));
        }
    }

    public void move() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);

            moveCondition(random.random(), i);
            checkMaxPosition(car.getCarPositions());
            outputView.resultView(car.getName(), car.getCarPositions());
        }

        System.out.println();
    }

    public void moveCondition(int randomValue, int index) {
        if (randomValue >= LIMIT) {
            cars.get(index).go();
        }
    }

    public String[] selectWinner() {
        for (Car car : cars) {
            isWinner(car);
        }

        return winners.toArray(new String[winners.size()]);
    }

    private void isWinner(Car car) {
        if (car.getCarPositions() == maxPosition) {
            winners.add(car.getName());
        }
    }

    private void checkMaxPosition(int p) {
        if (maxPosition < p) {
            maxPosition = p;
        }
    }
}
