package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private static final List<List<Integer>> record = new ArrayList<>();

    public void addCarPosition(int position) {
        List<Integer> roundCarPositions = record.get(record.size() - 1);
        roundCarPositions.add(position);
    }

    public void createNewRoundRecord() {
        record.add(new ArrayList<>());
    }

    public String printRecordWithSymbol(String symbol) {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> list : record) {
            for (int carPosition : list) {
                stringBuilder.append(symbol.repeat(carPosition));
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
