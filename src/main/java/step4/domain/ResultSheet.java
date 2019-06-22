package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultSheet {
    private List<Cars> resultSheet;

    public ResultSheet() {
        this.resultSheet = new ArrayList<>();
    }

    public void addResult(Cars cars) {
        resultSheet.add(cars);
    }

    public Cars getLastRoundResult(Round round) {
        return resultSheet.get(round.getRound() - 1);
    }

    public List<Cars> getResultSheet() {
        return resultSheet;
    }
}
