package racingcar.step3.domain;

import racingcar.step3.view.ResultView;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-02 오전 8:22
 * Developer : Seo
 */
public class Race {
    private List<Car> cars;
    private int turns;
    private ResultView rv;

    public Race(int inputCarNumber, int turns) {
        this.cars = new ArrayList<>();
        for (int i = 1; i < inputCarNumber + 1; i++) {
            cars.add(new Car());
        }
        this.turns = turns;
        this.rv = new ResultView();
    }

    public void run() {
        rv.printResultTitle();
        for (int i = 0; i < turns; i++) {
            roll();
        }
    }

    private void roll() {
        for (Car car : cars) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                car.record();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        rv.printTurnOver();
    }

}
