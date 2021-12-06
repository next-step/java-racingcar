package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 2", "3, 4"})
    @DisplayName("distance가 정상적으로 증가하는지 테스트 합니다.")
    void move(int initialValue, int movedValue) {
        Distance distance = new Distance(initialValue);
        assertThat(distance.move()).isEqualTo(new Distance(movedValue));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Equals 객체 생성시 값에 따른 equals 메소드 실행시 정상인지 확인합니다")
    void equals(int number) {
        assertThat(new Distance(number).equals(new Distance(number))).isTrue();
    }
}
