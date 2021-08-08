package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("처음 자동차의 위치는 0")
    void checkPosition() {
        assertThat(new Car()).isEqualTo(new Car(0));
    }

    @DisplayName("자동차 전진 규칙에 합당할 경우 전진")
    @ParameterizedTest(name = "랜덤값 {0}: 포지션 {1}")
    @CsvSource(value = {"false:0", "true:1"}, delimiter = ':')
    void moveCarAccordingToRandomValue(boolean movable, int position) {
        Car actual = new Car();
        actual.move(() -> movable);
        assertThat(actual).isEqualTo(new Car(position));
    }

    @DisplayName("Car의 생성자를 이용해서 깊은 복사가 가능하다.")
    @Test
    void deepCopyIsAvailableUsingConstructor() {
        Car toBeCopied = new Car();
        Car copied = new Car(toBeCopied);
        assertThat(toBeCopied.equals(copied)).isTrue();
        assertThat(toBeCopied == copied).isFalse();
    }
}
