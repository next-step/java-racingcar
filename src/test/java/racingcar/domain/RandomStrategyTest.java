package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RandomStrategy 클래스 테스트")
public class RandomStrategyTest {

    @Test
    @DisplayName("getNumber 메소드는 0~9 사이의 랜덤 숫자를 리턴한다.")
    void getNumber() {
        // given
        RandomStrategy randomStrategy = new RandomStrategy();

        // when
        int actual = randomStrategy.getNumber();

        // then
        assertThat(actual).isNotNull();
        assertThat(actual).isBetween(0, 9);
    }
}
