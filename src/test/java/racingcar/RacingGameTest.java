package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class RacingGameTest {

    @CsvSource(value = {"3:3", "3:4", "4:4", "1:2"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("RacingGame 객체 생성 테스트")
    public void generateRacingGameTest(int round, int carCount){
        assertThat(new RacingGame(round, carCount)).isExactlyInstanceOf(RacingGame.class);
    }

    @CsvSource(value = {"3:3", "3:4", "4:4", "1:2"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("RacingGame 생성 인자 값 검증 테스트")
    public void generateRacingGameArgumentTest(int round, int carCount) {
        assertThatCode(() -> new RacingGame(round, carCount)).doesNotThrowAnyException();
    }

    @CsvSource(value = {"3:3", "3:4", "4:4", "1:2"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("RacingGame play 메소드의 결과 크기는 car의 크기와 같다.")
    public void playTest(int round, int carCount) {
        int[] result = new RacingGame(round, carCount).play();
        assertThat(result).hasSize(carCount);
    }
}
