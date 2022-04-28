package study.step4.try3.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveRecord {
    private final List<String> status;
    private final StringBuilder stringBuilder;

    public MoveRecord() {
        this.status = new ArrayList<>();
        this.stringBuilder = new StringBuilder();
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
