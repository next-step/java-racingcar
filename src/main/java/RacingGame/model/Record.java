package RacingGame.model;

import java.util.List;

public class Record {
    private static final String CAR_POSITION_UNIT = "-";
    private static final String NEXT_LINE_SEPARATOR = System.lineSeparator();

    private final StringBuilder record;

    public Record() {
        this.record = new StringBuilder();
    }


    public void addStage(CarsManager carsManager) {
        carsManager.carNamePositions().forEach((name, position) -> {
            record.append(name)
                    .append(" : ")
                    .append(makeHypens(position));
            addNextLine();
        });

        addNextLine();
    }

    public String getRecord() {
        return record.toString();
    }

    private void addNextLine() {
        record.append(NEXT_LINE_SEPARATOR);
    }

    private static String makeHypens(int count) {
        return CAR_POSITION_UNIT.repeat(count);
    }

    public void addWinners(List<String> winnerNames) {
        record.append(String.join(",", winnerNames));
        record.append("가 최종 우승했습니다");
    }
}
