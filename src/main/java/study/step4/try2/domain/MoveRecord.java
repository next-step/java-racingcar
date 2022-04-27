package study.step4.try2.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveRecord {
    private final List<String> status;
    private final StringBuilder stringBuilder;
    private final String carName;

    public MoveRecord(String carName) {
        this.status = new ArrayList<>();
        this.stringBuilder = new StringBuilder();
        this.carName = carName;
    }

    public void print(String carName, int round) {
        System.out.println(carName + " : " + this.status.get(round));
    }

    public void save(int position) {
        this.stringBuilder.setLength(0);
        for (int i = 0; i < position; i++) {
            this.stringBuilder.append("-");
        }
        this.status.add(this.stringBuilder.toString());
    }
}
