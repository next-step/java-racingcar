package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.RacingGame;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;
    MoveStrategy moveStrategy = new RandomBasedMoveStrategy();

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(Arrays.asList(new String[]{"pobi", "crong", "honux"}), 5);
    }

    @Test
    void createCarsTest() {
        String data = "pobi,crong,honux";
        assertThat(data.split(",").length).isEqualTo(3);    //길이 확인
        assertThat(data.split(",")).containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("3대의 Car, 5번의 Round -> 15줄의 moveResult 생성")
    @Test
    void racingTest() {
        assertThat(racingGame.allRounds(moveStrategy)).hasSize(15);
    }
}
