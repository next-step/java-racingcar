package racingcar.step3.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * Created : 2020-11-02 오전 8:22.
 * Developer : Seo.
 */
public class Race {
    private Cars cars;
    private Record record;

    public Race(String carsName) {
        this.cars = new Cars(carsName);
        this.record = new Record();
    }

    public Record run(int turns) {
        for (int i = 0; i < turns; i++) {
            roll();
        }
        return this.record;
    }

    private void roll() {
        Map<String, Integer> turnRecords = new HashMap<>();
        for (Car car : cars.getCars()) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                turnRecords.put(car.getName(), car.getDistance());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        record.setTotalRecords(turnRecords);
    }

}
