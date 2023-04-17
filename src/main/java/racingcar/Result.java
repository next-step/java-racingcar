package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Integer> positionList = new ArrayList<>();

    public Result(List<Integer> positionList) {
        this.positionList = positionList;
    }

    public List<Integer> getPositionList() {
        return positionList;
    }
}
