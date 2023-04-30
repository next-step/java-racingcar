package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private final String DEFAULT_CAR_NAME = "kgh";

    private Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car(DEFAULT_CAR_NAME);
    }

    @DisplayName("3단계 - 자동차 경주 - 자동차 객체가 생성되는지 확인")
    @Test
    void create_car() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("3단계 - 자동차 경주 - 자동차 전진 이동 테스트")
    @Test
    void go_car() {
        car.go();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 자동차 객체 생성시 이름을 부여할 수 있는지 확인")
    @Test
    void create_car_with_name() {
        assertThat(car.getName()).isEqualTo(new Name(DEFAULT_CAR_NAME));
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 입력된 position 값과 자동차 객체의 position 값에 따라 동일 여부가 올바르게 반환되는지 확인")
    @ParameterizedTest(name = "testValue : {0}, 동일여부 : {1}")
    @CsvSource(value = {"0:true", "1:false"}, delimiter = ':')
    void is_same_position(int position, boolean expected) {
        assertThat(car.isSamePosition(position)).isEqualTo(expected);
    }

}
