package racing_car.step03;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int carCount = InputView.carCount();
        int tryCount = InputView.tryCount();

        Validation.inputValidation(carCount,tryCount);
        String[] cars = new String[carCount];
        Arrays.fill(cars, "");
        Race race = new Race();
        ResultView.print();
        for (int i = 0; i < tryCount; i++) {
            race.execute(cars);
            ResultView.result(cars);
        }
    }
}
