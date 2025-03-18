package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {


    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    public void 자동차대수가_0이하인경우_exception을_던진다(int carCount) {
        assertThatThrownBy(() -> new Racing(carCount, 10))
            .hasMessageContaining("자동차 대수는 0 이상을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -3})
    public void 회수가_0이하인경우_exception을_던진다(int tryCount) {
        assertThatThrownBy(() -> new Racing(3, tryCount))
            .hasMessageContaining("회수는 0 이상을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource({
        "5, 1, false",
        "3, 2, true"
    })
    public void move시_남은_시도횟수가_올바르게_감소한다(int carCount, int tryCount, boolean expected) {
        Racing racing = new Racing(carCount, tryCount);
        racing.move();
        assertThat(racing.isRemainTry()).isEqualTo(expected);
    }
}
