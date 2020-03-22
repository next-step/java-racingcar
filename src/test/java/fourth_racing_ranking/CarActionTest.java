package fourth_racing_ranking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import fourth_racing_ranking.Car;
import fourth_racing_ranking.CarAction;
import fourth_racing_ranking.RacingGame;

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
    @DisplayName("랜덤 값 확인")
    void randomTest(){
        assertThatThrownBy(() -> {
            CarAction.random();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("0~9만 허용");
    }
}
