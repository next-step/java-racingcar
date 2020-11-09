package study.racing;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingRecord {
    private LinkedList<Integer> positionList;
    private static String FORWARD_STRING = "-";
    public RacingRecord(LinkedList<Integer> positionList) {
        this.positionList = positionList;
    }

    public String getResultString() {
        return positionList.stream().map(i -> getRecordString(i)).collect(Collectors.joining("\n"));
    }

    private String getRecordString(int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> FORWARD_STRING)
                .collect(Collectors.joining());

    }
}
