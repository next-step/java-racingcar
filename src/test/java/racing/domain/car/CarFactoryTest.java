package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racing.domain.car.exception.MakeCarException;

public class CarFactoryTest {

    @Test
    @DisplayName("자동차 공장 생성 테스트")
    void ctor_test() {
        assertThatNoException().isThrownBy(() -> new CarFactory("name"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 빈값이면 예외를 발생한다")
    void name_null_throw_exception_test(String names) {
        assertThatThrownBy(() -> new CarFactory(names))
            .isInstanceOf(MakeCarException.class)
            .hasMessage("자동차는 1대 이상 입력 해야 합니다.");
    }


    @Test
    @DisplayName("이름을 입력하면 자동차를 생성한다")
    void inputName_create_car_test() {
        //given
        String names = "pobi,crong,honux";
        CarFactory carFactory = new CarFactory(names);

        //when
        Cars cars = carFactory.createCar();

        //then
        assertThat(cars.size()).isEqualTo(3);
    }

}
