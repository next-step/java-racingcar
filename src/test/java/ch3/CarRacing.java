package ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    private final InputView inputView;
    private final ResultView resultView;
    private List<Car> cars;
    private List<Integer> executeNumbers;

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
        this.executeNumbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
            Random random = new Random();
            this.executeNumbers.add(random.nextInt(10));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Integer> getExecuteNumbers() {
        return this.executeNumbers;
    }
}
