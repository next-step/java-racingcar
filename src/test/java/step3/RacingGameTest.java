package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {

    // Test

    @DisplayName("check only")
    @ParameterizedTest
    @CsvSource(value = {"3:5"}, delimiter = ':')
    void testNormal(int carsCount, int tryTimes) {

        RacingGame racingGame = new RacingGame(carsCount, tryTimes);
        racingGame.play();

        // 상태 변화 값이나 반환값이 없는 경우 오류 확인을 어떻게 해야 될까요....

    }

    @DisplayName("Arguments check / input negative number to cars count.")
    @ParameterizedTest
    @CsvSource(value = {"-1:2", "-100:3"}, delimiter = ':')
    void testInputCarsCountNegativeNumber(int carsCount, int tryTimes) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    RacingGame racingGame = new RacingGame(carsCount, tryTimes);
                }
        );
    }

    @DisplayName("Arguments check / input negative number to play times count.")
    @ParameterizedTest
    @CsvSource(value = {"2:-1", "3:-100"}, delimiter = ':')
    void testInputPlayTimesNegativeNumber(int carsCount, int tryTimes) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    RacingGame racingGame = new RacingGame(carsCount, tryTimes);
                }
        );
    }


    @DisplayName("scanner test")
    @ParameterizedTest
    @ValueSource(strings = {"5 3"})
        // 여러 케이스를 넣는 경우 에러발생 합니다. scanner 를 테스트 하는 방법이 있을까요
    void testScanner(String input) {

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        RacingGame racingGame = new RacingGame();
        racingGame.play();

    }


}