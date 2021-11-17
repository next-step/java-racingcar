package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("movement 초기값으로 Car 객체를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 1", "2, 2", "3, 3"})
    public void create(int movement, int expectedMovement) {
        // when
        Car car = new Car(movement);

        // then
        assertThat(car).isInstanceOf(Car.class);
        assertThat(car.getMovement()).isEqualTo(expectedMovement);
    }

    @DisplayName("Car의 move 함수는 round마다 MovingStrategy.canMove이면 movement가 증가한다.")
    @ParameterizedTest
    @CsvSource(value = {"4, 3", "10, 6", "20, 12", "100, 60"})
    public void increaseMovementRandomly(int rounds, int expectedMovement) {
        // given
        MovingStrategy strategy = new RandomMovingStrategy(0); // 테스트 결과 고정하기 위해 seed 지정

        // when
        Car car = new Car();
        IntStream.range(0, rounds).forEach(i -> car.move(strategy));

        // then
        assertThat(car.getMovement()).isEqualTo(expectedMovement);
    }
}
