package third_racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarActionTest {

    private RacingGame racingGame;
    private Car car;

    @BeforeEach
    void setUp() {

        this.racingGame = new RacingGame();

    }

    @Test
    @DisplayName("자동차갯수만큼셋팅")
    void firstSetTest(){
        int size = CarAction.firstSet(3).size();
        assertThat(size).isEqualTo(3);
    }

    @Test
    @DisplayName("랜덤 값 확인")
    void randomTest(){
        assertThatThrownBy(() -> {
            CarAction.random();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("0~9만 허용");
    }
}
