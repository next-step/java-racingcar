package racingcar.racing;

import racingcar.car.Car;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;
import static racingcar.random.GenerateRandom.moveCarForward;
import static racingcar.view.OutputView.printCarStatus;

public class Racing {
    public static void racingStart(int carCount, int tryCount) {
        List<Car> cars = initCars(carCount);
        resultView(cars, tryCount);
    }

    public static List<Car> initCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public static void resultView(List<Car> cars, int tryCount) {
        out.println("실행 결과");
        for(int i=0; i < tryCount; i++) {
            cars = moveCarForward(cars);
            printCarStatus(cars);
            out.println();
        }
    }
}
