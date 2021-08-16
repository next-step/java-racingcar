package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.ui.dto.InputDTO;
import kr.co.techmoa.carracing.ui.dto.OutputDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarGameServiceTest {

    @DisplayName("게임 전체 테스트")
    @Test
    void start() {
        RacingCarGameService racingCarGameService = new RacingCarGameService();
        InputDTO inputDTO = new InputDTO();
        inputDTO.setCarNames("A,B,C");
        inputDTO.setCarNum(3);
        inputDTO.setTryNumber(3);
        OutputDTO outputDTO = racingCarGameService.start(inputDTO);
        List<RacingResults> results = outputDTO.getResults();

        int resultTrials = results.size();
        int resultCars = results.get(0).getResults().size();

        assertEquals(resultTrials, 3);
        assertEquals(resultCars, 3);
    }


}