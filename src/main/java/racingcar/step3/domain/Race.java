package racingcar.step3.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-02 오전 8:22.
 * Developer : Seo.
 */
public class Race {

    public void run(String carsName, int turns, Record record) {
        String[] names = carsName.split(",");
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        for (int turn = 1; turn < turns + 1; turn++) {
            roll(turn, cars, record);
        }
    }

    private void roll(int turn, List<Car> cars, Record record) {
        for (Car car : cars) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                record.record(turn, car);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

}
