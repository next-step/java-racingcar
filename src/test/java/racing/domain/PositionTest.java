package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @DisplayName("자동차의 위치값을 가지는 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Position position = new Position();

        Position sut = new Position();

        assertThat(sut).isEqualTo(position);
    }

    @DisplayName("자동차의 위치를 증가시킬 수 있다.")
    @Test
    void increasePositionTest() {
        Position position = new Position(2);

        Position sut = new Position().increasePosition();

        assertThat(sut).isEqualTo(position);
    }

    @DisplayName("자동차 위치값이 큰 값을 반환 할 수 있다.")
    @Test
    void betterThanTest() {
        Position position = new Position(3);
        Position otherPosition = new Position(4);

        Position sut = position.betterThan(otherPosition);

        assertThat(sut).isEqualTo(otherPosition);
    }
}
