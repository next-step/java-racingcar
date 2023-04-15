package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<String> positionList;

    public Result(List<String> positionList) {
        this.positionList = positionList;
    }

    public List<String> getPositionList() {
        return new ArrayList<>(positionList);
    }
}
