package step3;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private final List<Integer> record = new ArrayList<Integer>();

    public void moveByRandomOnRound() {
        int preRecord = this.getPreRecord();
        if (this.newRandomNumber() > 3) {
            this.record.add(preRecord + 1);
            return;
        }
        this.record.add(preRecord);
    }

    private int getPreRecord() {
        if (record.size() > 0) {
            return record.get(record.size() - 1);
        }
        return 0;
    }

    private int newRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public List<Integer> getRacingRecord() {
        return record;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "record=" + record +
                '}';
    }
}
