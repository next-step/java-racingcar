package racing.dto;

import java.util.List;

public class RacingResultDto {
    private List<Integer> result;

    public RacingResultDto(List<Integer> result) {
        this.result = result;
    }

    public List<Integer> result() {
        return this.result;
    }
}
