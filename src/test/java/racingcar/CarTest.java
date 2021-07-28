package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    private final Car sut = new Car();

    @Test
    @DisplayName("move 하면 distance 가 1 증가")
    public void move() {
        int beforeDistance = sut.getDistance();

        sut.move();

        assertThat(sut.getDistance()).isEqualTo(beforeDistance + 1);
    }
}