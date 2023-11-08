package champion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    private static Car car;

    @BeforeEach
    void Car_객체_생성() {
        car = new Car("test");
    }

    @DisplayName("생성자 테스트")
    @Test
    void Car_생성자_멤버변수() {
        assertThat(car.carName()).isEqualTo("test");
        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @DisplayName("전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void Car_전진(int number) {

        car.move(number);

        assertThat(car.currentPosition()).isEqualTo(1);
    }

}
