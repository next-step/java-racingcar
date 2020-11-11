package racingcar.step3.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created : 2020-11-09 오전 8:25.
 * Developer : Seo.
 */
public class Record {
    private int bestRecord;
    private String winner;
    private Map<Integer, List<Car>> totalRecords;
    private List<Car> turnRecords;

    public Record(int bestRecord, String winner) {
        this.bestRecord = bestRecord;
        this.winner = winner;
        this.totalRecords = new HashMap<>();
        this.turnRecords = new ArrayList<>();
    }

    public void record(int turn, Car car) {
        if (!totalRecords.containsKey(turn)) {
            turnRecords = new ArrayList<>();
        }
        turnRecords.add(car);
        totalRecords.put(turn, turnRecords);

        if (Integer.compare(bestRecord, car.getDistance()) == -1) {
            this.bestRecord = car.getDistance();
            this.winner = car.getName();
        }
        if (!winner.equals("") && !winner.contains(car.getName())
                && bestRecord == car.getDistance()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.winner).append(", ").append(car.getName());
            this.winner = sb.toString();
        }
    }

    public String getWinner() {
        return this.winner;
    }

    public Map<Integer, List<Car>> getTotalRecords() {
        return this.totalRecords;
    }
}
