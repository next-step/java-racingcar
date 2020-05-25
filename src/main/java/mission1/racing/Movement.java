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
        for(int i = 0; i < inputCars.length; i++) {
            this.cars.add(new Car(inputCars[i]));
        }
    }

    public void move() {
        for(int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);

            moveCondition(random.random(), i);
            checkMaxPosition(car.carPositions);
            outputView.resultView(car.name, car.carPositions);
        }

        System.out.println();
    }

    public void moveCondition(int randomValue, int index) {
        if (randomValue >= LIMIT) {
            cars.get(index).go();
        }
    }

    public String[] selectWinner() {
        for(int i = 0; i < cars.size(); i++) {
            isWinner(cars.get(i));
        }

        return winners.toArray(new String[winners.size()]);
    }

    private void isWinner(Car car) {
        if(car.carPositions == maxPosition) {
            winners.add(car.name);
        }
    }

    private void checkMaxPosition(int p) {
        if(maxPosition < p) {
            maxPosition = p;
        }
    }
}
