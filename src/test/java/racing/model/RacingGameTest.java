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

    @DisplayName("랜덤값이 자동차 갯수 만큼 생성되는지 테스트")
    @Test
    void createRandomValue() {
        //given
        RacingGame racingGame = init();

        //when
        List<Integer> randomValue = racingGame.createRandomValue();

        //then
        assertEquals(3, randomValue.size());
    }


}