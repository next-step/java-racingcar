package racingcar.step3.domain;

import racingcar.step3.common.Consts;
import racingcar.step3.view.ResultView;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created : 2020-11-02 오전 8:22
 * Developer : Seo
 */
public class Race {
    private final int turns;
    private List<Car> cars;

    public Race(int turns) {
        this.turns = turns;
    }

    public List<Car> getCarSet() {
        return this.cars;
    }

    public void ready(int inputCarNumber) {
        this.cars = new ArrayList<>();
        for (int i = 1; i < inputCarNumber + 1; i++) {
            cars.add(new Car());
        }
    }

    public void run(ResultView rv) {
        System.out.println(Consts.RESULT);
        for (int i = 1; i < turns + 1; i++) {
            roll(rv, i);
        }
    }

    private void roll(ResultView rv, int i) {
        for (Car car : getCarSet()) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                rv.print(car);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        rv.printTurnOver(i);
    }

}
