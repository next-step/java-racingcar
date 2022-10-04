package step3.domain;

import step3.view.ResultView;

import java.util.List;

public class Play {

    private static final ResultView RESULT_VIEW = new ResultView();
    private static final RandomNumber RANDOM_NUMBER = new RandomNumber();
    
    public void playGame(int numberOfCar, int count) {
        List<Car> carList = createCarList(numberOfCar);
        for (int i = 0; i < count; i++) {
            run(carList);
        }
    }

    private List<Car> createCarList(int numberOfCar) {
        Cars cars = new Cars(numberOfCar);
        return cars.getCarList();
    }

    private void run(List<Car> carList) {
        carList.forEach(car -> car.moveCheck(RANDOM_NUMBER.randomNumber()));
        output(carList);
    }

    private void output(List<Car> carList) {
        RESULT_VIEW.output(carList);
    }
}
