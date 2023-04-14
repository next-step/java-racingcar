package study.step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car("coby");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 자동차테스트_멈춤(int count) {
        //given
        assertThat(car.isMove(count)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    public void 자동차테스트_이동(int count) {
        //given
        assertThat(car.isMove(count)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"jayden", "zuly.typark"})
    public void 자동차_이름테스트(String inputName) {
        //given

        assertThatThrownBy(() -> {
            car.checkName(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 다섯자 이상입니다.");
    }
}
