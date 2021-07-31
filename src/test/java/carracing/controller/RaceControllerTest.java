package carracing.controller;

import carracing.view.CarNameConsoleInput;
import carracing.view.RaceResultConsoleOutput;
import carracing.view.RoundConsoleInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {

    private final RaceController raceController = new RaceController();

    @Test
    @DisplayName("차량 이름 리스트 콘솔 입력 뷰 가져오기 테스트")
    public void getCarNameConsoleInput() {
        // given

        // when
        CarNameConsoleInput carNameConsoleInput = raceController.getCarNameConsoleInput();

        // then
        assertThat(carNameConsoleInput)
                .isNotNull()
                .isInstanceOf(CarNameConsoleInput.class);
    }

    @Test
    @DisplayName("라운드 수 콘솔 입력 뷰 가져오기 테스트")
    public void getRoundConsoleInput() {
        // given

        // when
        RoundConsoleInput roundConsoleInput = raceController.getRoundConsoleInput();

        // then
        assertThat(roundConsoleInput)
                .isNotNull()
                .isInstanceOf(RoundConsoleInput.class);
    }

    @Test
    @DisplayName("RaceResult 콘솔 출력 뷰 가져오기 테스트")
    public void getRaceResultConsoleOutput() {
        // given
        List<String> carNames = Arrays.asList("iiaii", "!!e!!");
        int roundNumber = 3;

        // when
        RaceResultConsoleOutput raceResultConsoleOutput = raceController.getRaceResultConsoleOutput(carNames, roundNumber);

        // then
        assertThat(raceResultConsoleOutput)
                .isNotNull()
                .isInstanceOf(RaceResultConsoleOutput.class);
    }

}
