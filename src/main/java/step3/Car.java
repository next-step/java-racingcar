package step3;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final List<Integer> records = new ArrayList<Integer>();

    public void moveByRandomOnRound() {
        int preRecord = this.getPreRecord();
        if (this.newRandomNumber() > 3) {
            this.records.add(preRecord + 1);
            return;
        }
        this.records.add(preRecord);
    }

    private int getPreRecord() {
        if (records.size() > 0) {
            return records.get(records.size() - 1);
        }
        return 0;
    }

    private int newRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public List<Integer> getRacingRecord() {
        return records;
    }

    @Override
    public String toString() {
        return "Car{" +
                "records=" + records +
                '}';
    }
}
