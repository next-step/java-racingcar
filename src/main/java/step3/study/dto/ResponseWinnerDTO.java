package step3.study.dto;

import java.util.List;

public class ResponseWinnerDTO {
    private final List<String> winnerNames;

    public ResponseWinnerDTO(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
