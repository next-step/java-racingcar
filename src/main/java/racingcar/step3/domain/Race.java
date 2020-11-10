package racingcar.step3.domain;

import racingcar.step3.view.ResultView;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-02 오전 8:22.
 * Developer : Seo.
 */
public class Race {
    private List<Car> cars;
    private int turns;

    public Race(String inputNames, int turns) {
        this.cars = new ArrayList<>();
        String[] names = inputNames.split(",");
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        this.turns = turns;
    }

    public void run(ResultView rv, Record record) {
        rv.printResultTitle();
        for (int i = 0; i < turns; i++) {
            roll(rv, record);
            rv.printTurnOver();
        }
        rv.printWinner(record);
    }

    private void roll(ResultView rv, Record record) {
        for (Car car : cars) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                record.record(car);
                rv.printResult(car);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

}
