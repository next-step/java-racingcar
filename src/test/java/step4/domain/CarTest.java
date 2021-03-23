package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.strategy.TestMovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차가 전진하면 position 값이 1증가한다.")
    @Test
    void move() {
        // given
        Car car = Car.from("test");
        int beforePosition = car.getPosition();

        // when
        car.move(new TestMovableStrategy());

        // then
        assertThat(car.getPosition()).isEqualTo(beforePosition + 1);
    }

    @DisplayName("우승자 포지션과 동일할 경우 우승자인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,false", "1,true", "2,false"})
    void isWinner(int maxPosition, boolean expected) {
        // given
        Car car = Car.from("test");
        Position winnerPosition = new Position(maxPosition);

        // when
        car.move(new TestMovableStrategy());

        // then
        assertThat(car.isWinner(winnerPosition)).isEqualTo(expected);
    }
}
