package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RandomStrategy 클래스 테스트")
public class RandomStrategyTest {

    @Test
    @DisplayName("isMove 메소드는 랜덤값이 기준값보다 크면 true를 리턴한다.")
    void isMove() {
        // given
        RandomStrategy randomStrategy = new RandomStrategy();

        // when
        boolean actual = randomStrategy.isMove();

        // then
        assertThat(actual).isNotNull();
        assertThat(actual).isIn(true, false);
    }
}
