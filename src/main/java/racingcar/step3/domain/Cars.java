package racingcar.step3.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

/**
 * Created : 2020-11-12 오전 10:20
 * Developer : Seo
 */
public class Cars {
    private final List<Car> carList;
    private Record record;

    public Cars(Record record, String carsName) {
        this.record = record;
        this.carList = new ArrayList<>();
        String[] arrCarsName = carsName.split(",");
        for (String carName : arrCarsName) {
            this.carList.add(new Car(carName));
        }
    }

    public void roll() {
        Map<String, Integer> turnRecords = new HashMap<>();
        for (Car car : carList) {
            try {
                car.move(SecureRandom.getInstanceStrong().nextInt(10));
                turnRecords.put(car.getName(), car.getDistance());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        record.setTotalRecords(turnRecords);
    }

    public List<Map<String, Integer>> getTotalRecords() {
        return this.record.getTotalRecords();
    }

    public int getBest() {
        Map<String, Integer> lastRecord = getTotalRecords().get(getTotalRecords().size() - 1);
        Optional<Map.Entry<String, Integer>> entry = lastRecord.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        int best = 0;
        if (entry.isPresent()) {
            best = entry.get().getValue();
        }
        return best;
    }

    public String getWinner() {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> lastRecord = getTotalRecords().get(getTotalRecords().size() - 1);
        for (Map.Entry<String, Integer> entry2 : lastRecord.entrySet()) {
            if (entry2.getValue() == getBest()) {
                sb.append(", ").append(entry2.getKey());
            }
        }
        return sb.toString().replaceFirst(", ", "");
    }

}
