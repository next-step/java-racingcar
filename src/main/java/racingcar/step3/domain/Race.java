package racingcar.step3.domain;

import racingcar.step3.common.Consts;
import racingcar.step3.service.ResultView;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * Created : 2020-11-02 오전 8:22
 * Developer : Seo
 */
public class Race {
    private final int cars;
    private final int turns;
    private final ResultView rv;
    private Set<Car> carSet;

    public Race(int cars, int turns, ResultView rv) {
        this.cars = cars;
        this.turns = turns;
        this.rv = rv;
    }

    public void ready() {
        this.carSet = new HashSet<>();
        for (int i = 1; i < cars + 1; i++) {
            carSet.add(new Car(String.valueOf(i)));
        }
    }

    public void run() {
        System.out.println(Consts.RESULT);
        for (int i = 1; i < turns + 1; i++) {
            roll(rv, i);
        }
    }

    private void roll(ResultView rv, int i) {
        for (Car car : getCarSet()) {
            try {
                if (SecureRandom.getInstanceStrong().nextInt(10) > 3) {
                    car.move();
                }
                rv.print(car);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        System.out.println("turn " + i + " 종료");
        System.out.println();
    }

    public Set<Car> getCarSet() {
        return this.carSet;
    }

}
