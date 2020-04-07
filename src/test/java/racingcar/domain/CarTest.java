package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    Car car;

    @BeforeEach
    public void setup() {
        car = new Car(() -> true, "test");
    }

    @DisplayName("항상 성공하는 전략 주입시 position 증가")
    @Test
    public void movePossible() {
        Car car = new Car(() -> true, "test");

        car.moveIfPossible();
        assertThat(car.getPosition()).isEqualTo(1);

        car.moveIfPossible();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @DisplayName("항상 실패하는 전략 주입시 position 유지")
    @Test
    public void moveImpossible() {
        Car car = new Car(() -> false, "test");

        car.moveIfPossible();
        assertThat(car.getPosition()).isEqualTo(0);

        car.moveIfPossible();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("두 번 이동시 max position 비교")
    @ParameterizedTest
    @CsvSource({"1,2", "2,2", "3,3"})
    public void maxPosition(int position, int expected) {
        car.moveIfPossible();
        car.moveIfPossible();

        assertThat(car.getMaxPosition(position)).isEqualTo(expected);
    }

    @DisplayName("maxPosition이 같을 때 위너 리스트에 추가")
    @Test
    public void addWhenWinner() {
        car.moveIfPossible();

        List<Car> winners = new ArrayList<>();
        car.addWhenWinner(winners, 1);

        assertThat(winners.contains(car)).isTrue();
    }

    @DisplayName("maxPosition이 다를 때 위너 리스트에 추가 안됨")
    @Test
    public void notAddWinner() {
        car.moveIfPossible();

        List<Car> winners = new ArrayList<>();
        car.addWhenWinner(winners, 2);

        assertThat(winners.contains(car)).isFalse();
    }

    @DisplayName("잘못된 이름으로 생성시 에러")
    @ParameterizedTest
    @NullAndEmptySource
    public void invalidCarName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(() -> true, name));
    }

}