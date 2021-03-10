package racing.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    RacingGame init() {
        String[] racingCarNames = "LG,SKT,KT".split(",");
        return new RacingGame(racingCarNames);
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void moveAndStop() {
        //given
        RacingGame racingGame = init();
        List<Integer> randomValue = createRandomValue(5, 2, 5);
        //when
        RacingCars racingCars = racingGame.moveAndStop(randomValue);
        List<RacingCarDto> resultCars = racingCars.createDtoList();

        //then
        assertThat(resultCars).containsExactly(new RacingCarDto("LG", 1), new RacingCarDto("SKT", 0), new RacingCarDto("KT", 1));
    }

    @DisplayName("우승자 선택 테스트")
    @Test
    void setCoWinner() {
        //given
        RacingGame racingGame = init();
        List<Integer> randomValue = createRandomValue(5, 5, 2);
        racingGame.moveAndStop(randomValue);

        //when
        List<String> winner = racingGame.findWinners();

        //then
        assertEquals(2, winner.size());
        assertEquals("LG", winner.get(0));
        assertEquals("SKT", winner.get(1));
    }

    private List<Integer> createRandomValue(int firstCarMovePosition, int secondCarMovePosition,
                                            int thirdCarMovePosition) {
        return List.of(firstCarMovePosition, secondCarMovePosition, thirdCarMovePosition);
    }
}