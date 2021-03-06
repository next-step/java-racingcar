package racingcar;

import racingcar.car.Car;
import racingcar.car.NextStepCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    InputView inputView;
    ResultView resultView;
    public Racing() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void start() {
        List<Car> cars = new ArrayList<>();

        inputView.print("자동차 대수는 몇 대 인가요?");
        int carCount = inputView.scanner.nextInt();
        inputView.print("시도할 회수는 몇 회 인가요?");
        int forwartCount = inputView.scanner.nextInt();
        Random random = new Random();

        for (int i = 0; i < carCount; i++) {
            cars.add(new NextStepCar());
        }
        for(Car car : cars) {
            car.moveForward(random.nextInt(10));
        }
        for (int i = 0; i < forwartCount; i++) {
            for(Car car : cars) {
                car.moveForward(random.nextInt(10));
                resultView.print("-".repeat(car.getPosition()));
            }
            System.out.println();
        }
    }
}
