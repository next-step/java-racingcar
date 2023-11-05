package ch3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final InputView inputView;
    private final ResultView resultView;
    private List<Car> cars;

    public CarRacing(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public ResultView getResultView() {
        return resultView;
    }

    public void makingCar(int number) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
