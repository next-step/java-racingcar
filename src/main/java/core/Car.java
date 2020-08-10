package core;

import java.util.ArrayList;
import java.util.List;

public class Car {
    List<String> roundResult;

    Car() {
        roundResult = new ArrayList<>();
    }

    public List<String> getRoundResult() {
        return roundResult;
    }

    public void setRoundResult(List<String> roundResult) {
        this.roundResult = roundResult;
    }
}
