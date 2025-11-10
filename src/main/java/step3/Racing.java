package step3;

import java.util.List;

public class Racing {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.ready();

        List<Car> cars = Car.set(inputView.getCar());

        ResultView.race(cars, inputView.getDrive());
    }
}
