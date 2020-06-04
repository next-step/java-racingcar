package camp.nextstep.edu.nextstep8.racing;

import java.util.List;
import java.util.stream.Collectors;

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
        congratulationWinner();
    }

    public void congratulationWinner() {
        List<RacingCar> finalEntryList = records.get(records.size()-1).getEntryList();
        System.out.println(getWinner(finalEntryList) + "가 최종 우승했습니다.");
    }

    private String getWinner(List<RacingCar> entryList) {
        return entryList.stream()
                .filter(car -> car.getPosition() >= getWinnerPosition(entryList))
                .map(car -> car.getName())
                .collect(Collectors.joining(","));
    }

    private int getWinnerPosition(List<RacingCar> entryList) {
        return entryList.stream()
                .mapToInt(c -> c.getPosition())
                .max().getAsInt();
    }

    private String generateDistance(int count) {
        System.out.println(count);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < count; i++) {
            builder.append(DISPLAY_SYMBOL);
        }
        return builder.toString();
    }
}
