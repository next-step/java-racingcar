package study.racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import study.racing.exception.InvalidDistanceException;

class DistanceTest {

    public static final int INITAL_DISTANCE = 0;

    @DisplayName("객체 생성시 0보다 작은 값이 들어오면 생성실패하는지 검증")
    @ParameterizedTest
    @ValueSource(ints = { -100, -1 })
    void initValidation(int position) {
        assertThatThrownBy(() -> new Distance(position)).isInstanceOf(InvalidDistanceException.class);
    }

    @DisplayName("초기화 된 Distance의 거리가 0인지 검증")
    @Test
    void initTest() {
        assertThat(Distance.init().getPosition()).isEqualTo(INITAL_DISTANCE);
    }

    @DisplayName("increase가 호출될 때마다 Distance의 거리가 증가하는지 검증")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 100 })
    void increaseTest(int moveCount) {
        Distance distance = Distance.init();
        for (int i = 0; i < moveCount; i++) {
            distance.increase();
        }
        assertThat(distance.getPosition()).isEqualTo(moveCount);
    }
}
