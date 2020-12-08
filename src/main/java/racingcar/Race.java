package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public void play() {
        InputView inputView = new InputView();
        inputView.input();

        int numberOfCar = inputView.getNumber();
        int playCount = inputView.getCount();

        ResultView resultView = new ResultView();

        List<Car> cars = ready(numberOfCar);

        System.out.println("\n실행결과");
        for (int i = 0; i < playCount; i++) {
            resultView.resultRacing(cars);
        }
    }

    private List<Car> ready(int numberOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
