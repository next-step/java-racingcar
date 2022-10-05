package racingcar.model;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    List<Position> positions;

    @BeforeEach
    void setUp() {
        positions = new ArrayList<>();
        positions.add(new Position(1));
        positions.add(new Position(2));
        positions.add(new Position(3));
    }

    @Test
    @DisplayName("Position을 기본생성자로 생성하면 위치가 0이다.")
    void createPosition() {
        Position expected = new Position(0);

        Position actual = new Position();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("위치가 이동된 새로운 Position 인스턴스를 리턴한다.")
    void moveForward() {
        Position expected = new Position(1);
        Position position = new Position();

        Position actual = position.moveForward();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void negative_value() {
        ThrowingCallable actual = () -> new Position(-1);

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage("0 미만의 수는 Position이 될 수 없습니다.");
    }
}