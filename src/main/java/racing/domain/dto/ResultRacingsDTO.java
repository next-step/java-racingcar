package racing.domain.dto;

import java.util.List;

public class ResultRacingsDTO {

    private final List<RacingResultDTO> racingResultDTO;

    public ResultRacingsDTO(List<RacingResultDTO> racingResultDTOS) {
        this.racingResultDTO = racingResultDTOS;
    }

    public List<RacingResultDTO> getResultsRacings() {
        return racingResultDTO;
    }

}
