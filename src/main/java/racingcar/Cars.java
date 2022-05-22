package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private ResultView resultView = new ResultView();
    private List<Car> cars = new ArrayList<>();
    private int maxPosition = 0;

    public Cars(String inputNames) {
        CarNameValidation carNameValidation = new CarNameValidation(inputNames);
        makeCars(carNameValidation.getCarNames());
    }

    public void makeCars(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public void move() {
        for (Car car : cars) {
            car.moveOrStop(RandomNumber.randomNumberExtraction());
            saveMaxPosition(car.getPosition());
            resultView.roundResult(car.getCarName(), car.getPosition());
        }
        resultView.emptyLIne();
    }

    protected void saveMaxPosition(int position) {
        maxPosition = Math.max(maxPosition, position);
    }

    public int maxPosition() {
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
