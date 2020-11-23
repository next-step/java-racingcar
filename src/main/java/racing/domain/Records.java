package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Records {

    private final List<Record> records;

    public Records() {
        this.records = new ArrayList<>();
    }

    public List<Record> getRecords() {
        return records;
    }

    public void recordRound(RacingCars racingCars) {
        records.clear();

        for (Car car : racingCars.getCars()) {
            records.add(new Record(car));
        }
    }

    public List<String> findWinners() {
        HashMap<Integer, List<String>> scoreBoard = new HashMap<>();

        for (Record record : records) {
            List<String> names =
                    scoreBoard.computeIfAbsent(record.position, name -> new ArrayList<>());

            names.add(record.name);
        }

        int max = Collections.max(scoreBoard.keySet());

        return scoreBoard.get(max);
    }

    public static class Record {

        private final String name;

        private final int position;

        private Record(Car car) {
            this.name = car.getName();
            this.position = car.getPosition().getPosition();
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }
}
