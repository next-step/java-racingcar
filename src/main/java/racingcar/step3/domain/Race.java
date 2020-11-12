package racingcar.step3.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created : 2020-11-02 오전 8:22.
 * Developer : Seo.
 */
public class Race {

    public void run(Cars cars, int turns, Record record) {
        for (int turn = 1; turn < turns + 1; turn++) {
            roll(cars, turn, record);
        }
        for (Car car : cars.getCars()) {
            cars.setWinner(car);
        }
    }

    private void roll(Cars cars, int turn, Record record) {
        for (Car car : cars.getCars()) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                record.record(car, turn);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

}
