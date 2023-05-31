package edu.nextstep.camp.racing.service;

import edu.nextstep.camp.racing.model.RacingResult;
import edu.nextstep.camp.racing.model.RacingStartInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {

    private static final int 각_차량_움직임_구분_개행_1줄 =1;
    private static final int 실행_결과_1줄 = 1;


    private RacingService racingService;

    @BeforeEach
    public void init(){
        racingService = new RacingService();
    }

    @ParameterizedTest
    @CsvSource(value = {"5:16", "5:66", "3:23", "8:48"}, delimiter = ':')
    public void startRace(String vehicleCnt, String movingCnt){
        RacingStartInput racingStartInput = new RacingStartInput(vehicleCnt, movingCnt);

        RacingResult result = racingService.startRace(racingStartInput);
        String resultStr =  result.toString();

        assertThat(resultStr.split("\n").length)
                .isEqualTo(
                        ( Integer.parseInt(vehicleCnt) + 각_차량_움직임_구분_개행_1줄 )
                                * Integer.parseInt(movingCnt) + 실행_결과_1줄
                        );
    }
}
