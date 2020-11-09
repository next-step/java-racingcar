package study.racing;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingRecord {
    private LinkedList<Integer> positionList;

    public RacingRecord(LinkedList<Integer> positionList) {
        this.positionList = positionList;
    }

    public LinkedList<Integer> getPositionList() {
        return positionList;
    }
}
