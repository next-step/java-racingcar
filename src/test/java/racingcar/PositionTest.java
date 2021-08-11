package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositionTest {

    @DisplayName("increse메소드는 position을 1 증가 시킨다.")
    @Test
    void increaseMethodAddOneToCurrentPosition() {
        assertThat(new Position(0).increase()).isEqualTo(new Position(1));
    }

    @DisplayName("Position의 생성자를 이용해서 깊은 복사가 가능하다.")
    @Test
    void deepCopyIsAvailableUsingConstructor() {
        Position toBeCopied = new Position(0);
        Position copied = new Position(toBeCopied);
        assertThat(toBeCopied.equals(copied)).isTrue();
        assertThat(toBeCopied == copied).isFalse();
    }

    @DisplayName("Position은 0이상의 정수이다")
    @Test
    void positionHasToBeIntegerNotLessThanZere() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Position(-1)).withMessageMatching("자동차의 위치는 0 이상의 정수여야합니다.");
    }
}
