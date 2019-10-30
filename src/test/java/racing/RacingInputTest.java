package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingInputTest {

    @Test
    @DisplayName("시도 할 횟수 유저 입력 테스트")
    void inputTryCount() {
        String input = "-1\n2";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        RacingInput racingInput = new RacingInput(scanner);

        assertThat(racingInput.inputTryCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 이름 유저 입력 테스트")
    void inputRacerNames() {
        String expectString = "dave,pobi";
        String input = "\n" + expectString;
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        RacingInput racingInput = new RacingInput(scanner);

        assertThat(racingInput.inputRacerNames()).isEqualTo(expectString);
    }
}
