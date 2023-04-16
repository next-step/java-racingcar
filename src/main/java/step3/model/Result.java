package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private final List<Integer> positionList;

    public Result(List<Integer> positionList) {
        this.positionList = positionList;
    }

    public List<Integer> getPositionList() {
        return new ArrayList<>(positionList);
    }
    public List<String> getDisplayList() {
        return new ArrayList<>(positionList).stream().map(position -> "-".repeat(position)).collect(Collectors.toList());
    }

}
