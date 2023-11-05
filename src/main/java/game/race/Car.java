package game.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private static final String MARK = "-";
    private static final int THRESHOLD = 4;

    private final List<String> tireMarks = new ArrayList<>();

    public List<String> getTireMarks() {
        return tireMarks;
    }

    public void goForward(int tryCnt) {
        StringBuilder builder = new StringBuilder();
        builder.append(MARK);
        for (int idx = 0; idx < tryCnt; idx++) {
            int number = new Random().nextInt(10) + 1;
            append(builder, number);
        }

        tireMarks.add(builder.toString());
    }

    private void append(StringBuilder builder, int number) {
        if (THRESHOLD < number) {
            builder.append(MARK);
        }
    }
}
