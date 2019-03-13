package racingcar.web.dto;

import java.util.List;

public class RaceResultDTO {
    private List<RunResultDTO> runResults;

    public RaceResultDTO(List<RunResultDTO> runResults) {
        this.runResults = runResults;
    }

    public List<RunResultDTO> getRunResults() {
        return runResults;
    }
}
