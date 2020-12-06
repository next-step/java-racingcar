package step3;

import step3.view.InputView;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static step3.RandomNumberProvider.*;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.setCount();
        List<Car> cars = setUpRacingCar(inputView);

        play(inputView, cars);
    }

    public static List<Car> setUpRacingCar(InputView inputView) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputView.getCarCount(); i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public static void play(InputView inputView, List<Car> cars) {
        for (int r = 0; r < inputView.getRoundCount(); r++) {
            cars.forEach(c -> c.accelerate(provideRandomNumber())); // 자동차 주행
            ResultView.getRoundResult(cars, "-"); // 결과 보기
        }
    }
}
