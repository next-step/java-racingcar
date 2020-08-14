package CarRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @DisplayName("문자열 List에 담기")
    @ParameterizedTest
    @ValueSource(strings = {"tony,tom,boby"})
    void splitCarsName(String carsName) {
        List<String> nameOfCar = RacingGame.splitCarsName(carsName);

        assertThat(nameOfCar).containsExactly("tony", "tom", "boby");
        assertThat(nameOfCar.size()).isEqualTo(3);
    }

    @DisplayName("자동차 이름이 5를 넘기는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"harry, austin, john"})
    void overCarNameSize(String carsName) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingGame.splitCarsName(carsName);
        });
    }

    @DisplayName("자동차 이름을 쉼표를 기준으로 구분")
    @ParameterizedTest
    @ValueSource(strings = {"tony%tom", "mike@big"})
    void standardOfSplit(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingGame.splitCarsName(input);
        });
    }
}
