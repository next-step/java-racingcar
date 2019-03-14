package domain;

import java.util.List;
import lombok.Getter;

public class RoundResult {
    @Getter
    private Integer roundNumber;

    @Getter
    private List<CarResult> carResults;

    public RoundResult(Integer roundNumber, List<CarResult> carResults) {
        this.roundNumber = roundNumber;
        this.carResults = carResults;
    }
}
