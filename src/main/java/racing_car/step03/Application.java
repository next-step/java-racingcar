package racing_car.step03;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int carCount = InputView.carCount();
        int tryCount = InputView.tryCount();

        Validation.inputValidation(carCount,tryCount);
        List<Car> cars = Car.buildCarObject(carCount);
        Race race = new Race();
        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            race.execute(cars);
            ResultView.result(cars);
        }
    }
}
