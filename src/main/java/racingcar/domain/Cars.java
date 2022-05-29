package racingcar.domain;

import racingcar.util.RandomNumber;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private int maxPosition = 0;

    public Cars(String inputNames) {
        inputNames = inputNames.replace(" ", "");

        CarNames carNames = new CarNames(inputNames);
        makeCars(carNames.toArray(inputNames));
    }

    private void makeCars(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public void move() {
        ResultView resultView = new ResultView();
        
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
        return Collections.unmodifiableList(cars);
    }
}
