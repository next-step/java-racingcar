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
       showAllRecordResult();
       congratulationWinner();
    }

    private void showAllRecordResult() {
        StringBuilder output = new StringBuilder();
        int round = 1;
        for(RacingEntry record : records) {
            output.append("=====[" + (round++) + " ROUND" + "]=====" + ENTER);
            output.append(generateDistance(record.getEntryList()));
        }
        System.out.println(output.toString());
    }

    private String generateDistance(List<RacingCar> entryList) {
        StringBuilder builder = new StringBuilder();
        for(RacingCar car : entryList) {
            builder.append(car.getName() + " : " + makeDistanceSymbol(car.getPosition()) + ENTER);
        }
        return builder.toString();
    }

    private String makeDistanceSymbol(int count) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < count; i++) {
            builder.append(DISPLAY_SYMBOL);
        }
        return builder.toString();
    }

    public void congratulationWinner() {
        int finalRoundIndex = records.size() - 1;
        System.out.println(records.get(finalRoundIndex).getWinner() + " 가 최종 우승했습니다.");
    }
}
