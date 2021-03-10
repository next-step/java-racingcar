package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTurnTest {

    @DisplayName("게임턴 음수 예외 테스트")
    @Test
    void negativeTurn() {
        assertThatThrownBy(() -> {
            GameTurn gameTurn = new GameTurn(-2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("게임 턴은 0이상이여야 합니다.");
    }

    @DisplayName("매턴 게임 동작 테스트")
    @Test
    void turn() {
        //given
        RacingGame racingGame = new RacingGame("LG,SKT,KT".split(","));
        GameTurn gameTurn = new GameTurn(1);


        //when
        RacingCars racingCars = gameTurn.turn(racingGame, createRandomValue(1, 5, 6));
        List<RacingCarDto> racingCarDto = racingCars.createDtoList();

        //then
        assertThat(racingCarDto).containsExactly(new RacingCarDto("LG", 0), new RacingCarDto("SKT", 1), new RacingCarDto("KT", 1));
    }

    private List<Integer> createRandomValue(int firstCarMovePosition, int secondCarMovePosition,
                                            int thirdCarMovePosition) {
        return List.of(firstCarMovePosition, secondCarMovePosition, thirdCarMovePosition);
    }
}