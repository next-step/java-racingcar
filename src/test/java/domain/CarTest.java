package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("jylee");
    }

    @Test
    @DisplayName("현재 위치를 가져온다.")
    public void getPosition() {
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false", "3,false"})
    @DisplayName("위치를 체크한다.")
    public void checkPosition(int position, boolean result) {
        assertThat(car.checkPosition(position)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"jylee"})
    @DisplayName("자동차 이름을 가져온다.")
    public void getName(String name) {
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("이동한다.")
    public void move() {
        int currentPosition = car.getPosition();
        assertThat(car.move(new MoveOneForwardStrategy()).getPosition()).isEqualTo(currentPosition + 1);
    }

    @Test
    @DisplayName("정지한다.")
    public void stop() {
        int currentPosition = car.getPosition();
        assertThat(car.move(() -> 0).getPosition()).isEqualTo(currentPosition);
    }

}
