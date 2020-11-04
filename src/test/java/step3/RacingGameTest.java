package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.strategy.RandomStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RacingGameTest {

    @DisplayName("객체 생성 테스트 - 전략을 전달알했을때 예외 발생 테스트")
    @Test
    public void test() {
        assertThatThrownBy(() -> {
            RacingGame racingGame = new RacingGame(10, null);
        }).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("레이싱 카 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {
            2,
            6,
            3,
            8,
            9,
    })
    public void test1(Integer value) {
        RacingGame racingGame = new RacingGame(value, new RandomStrategy());
        RacingCarList racingCarList = racingGame.getRacingCarList();
        Integer racingCarSize = racingCarList.getRacingStatus().size();

        assertThat(value).isEqualTo(racingCarSize);
    }


}
