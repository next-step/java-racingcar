package RacingGame.model;

import java.util.List;
import java.util.stream.Collectors;

public class Record {
    private static final String CAR_POSITION_UNIT = "-";
    private static final String NEXT_LINE_SEPARATOR = System.lineSeparator();
    private final StringBuilder record;

    public Record() {
        this.record = new StringBuilder();
    }


    public void addStage(CarsManager carsManager) {
        for (Car car : carsManager.cars()) {
            record.append(car.name())
                    .append(" : ")
                    .append(makeHypens(car.getPosition()));
            addNextLine();
        }

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
