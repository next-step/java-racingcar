package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.ResultView.*;

public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.userInput();

        Car car = new Car();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < inputView.inputCarCount; i++) {
            carList.add(car.addCar());
        }

        for (int i = 0; i < inputView.tryCarCount; i++) {
            resultCars(carList);
        }
    }
}
