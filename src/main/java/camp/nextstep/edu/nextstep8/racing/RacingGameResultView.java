package camp.nextstep.edu.nextstep8.racing;

import java.util.List;

public class RacingGameResultView {
    private static final String DISPLAY_SYMBOL = "-";
    private static final String ENTER = "\n";
    private List<RacingEntry> records;

    public RacingGameResultView(List<RacingEntry> records) {
        this.records = records;
    }

    public void showResult() {
        StringBuilder output = new StringBuilder();
        int round = 1;
        for(RacingEntry record : records) {
            output.append("=====[" + (round++) + " ROUND" + "]=====" + ENTER);
            for(RacingCar car : record.getEntryList()) {
                output.append(car.getName() + " : " + generateDistance(car.getPosition()) + ENTER);
            }
            output.append(ENTER);
        }
        System.out.println(output.toString());
    }
    private String generateDistance(int count) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < count; i++) {
            builder.append(DISPLAY_SYMBOL);
        }
        return builder.toString();
    }
}

