package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidUserInputException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void init() {
        this.cars = new Cars();
    }


    @Test
    @DisplayName("사용자 자동차 갯수 입력 성공 테스트")
    void 자동차_갯수_입력_성공() {

        int input = 2;
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);

        cars.setUserInputCountOfCar();
        assertThat(cars.getCars().size()).isEqualTo(input);
    }

    @Test
    @DisplayName("사용자 자동차 갯수 입력 실패 테스트(1대 입력)")
    void 자동차_갯수_입력_실패_1대입력() {
        int input = 1;
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> cars.setUserInputCountOfCar())
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessage("2개 이상의 자동차를 입력해야 시작 가능합니다.");
    }

    @Test
    @DisplayName("Car 추가 성공 테스트")
    void addCar_성공() {
        cars.addCars(2);
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Cars 생성 성공 테스트")
    void setCars_성공() {
        cars.addCars(3);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

}
