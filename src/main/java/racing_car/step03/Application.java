package racing_car.step03;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int carCount = InputView.carCount();
        int tryCount = InputView.tryCount();

        Validation.inputValidation(carCount,tryCount);
        List<Car> car = new ArrayList<>();
        Race race = new Race();
        ResultView.print();
        for (int i = 0; i < tryCount; i++) {
            race.execute(car);
            ResultView.result(car);
        }
    }
}
