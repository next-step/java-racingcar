package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.rule.RandomRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameSetTest {

    RandomRule randomRule;
    GameSet settings;

    @BeforeEach
    void settings() {
        randomRule = new RandomRule();
        settings = new GameSet(randomRule);
    }

    @Test
    @DisplayName("게임 설정 - 규칙 설정 확인")
    void checkRuleSet() {
        assertThat(settings.getRule()).isEqualTo(randomRule);
    }

    @ParameterizedTest
    @DisplayName("게임 설정 - 자동차 수 및 이동 수 확인")
    @ValueSource(ints = {4, 5})
    void checkNumberOfCarAndMovements(int number) {
        // 기본 값
        assertThat(settings.getNumberOfCars()).isZero();
        assertThat(settings.getNumberOfMove()).isZero();

        // 설정 값
        settings.setNumberOfCars(number);
        settings.setNumberOfMove(number);

        assertThat(settings.getNumberOfCars()).isEqualTo(number);
        assertThat(settings.getNumberOfMove()).isEqualTo(number);
    }

    @Test
    @DisplayName("게임 설정 - 자동차, 이동 수 음수 입력 확인")
    void checkNegativeNumber() {
        assertThatThrownBy(() -> settings.setNumberOfCars(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 설정 - 규칙 설정 에러 발생")
    void createConstructorException() {
        assertThatThrownBy(() -> new GameSet(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
