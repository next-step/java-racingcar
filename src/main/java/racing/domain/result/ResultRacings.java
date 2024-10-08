package racing.domain.result;

import java.util.List;

public class ResultRacings {

    private final List<ResultRacing> resultRacings;

    public ResultRacings(List<ResultRacing> resultRacings) {
        this.resultRacings = resultRacings;
    }

    public List<ResultRacing> getResultsRacings() {
        return resultRacings;
    }

}
