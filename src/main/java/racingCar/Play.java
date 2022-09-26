package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private final List<Car> cars = new ArrayList<>();
    ResultView resultView = new ResultView();

    Play(int carCnt, int round) {
        ready(carCnt);
        race(round);
    }

    private void ready(int carCnt) {
        for (int i = 0; i < carCnt; i++) {
            cars.add(new Car(i, 0));
        }
    }

    private void race(int round) {
        for (int i = 0; i < round; i++) {
            playRace();
        }
    }

    private void playRace() {
        for (Car car : cars) {
            car.move(car.makeRandomNum());
            resultView.print(car.getPosition());
        }
        System.out.println();
    }
}
