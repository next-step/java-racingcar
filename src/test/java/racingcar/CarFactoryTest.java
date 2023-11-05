package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarFactoryTest {
    private CarFactory carFactory;
    private final List<String> DEFAULT_CAR_NAME = List.of("pobi","crong","honux");

    public void setUp() {
        this.carFactory = new CarFactory();
    }

    @DisplayName("차량이름으로 차량생성")
    @Test
    public void 차량이름으로_차량생성() {
        //given
        setUp();
        //when
        carFactory.participants(DEFAULT_CAR_NAME);
        List<Car> cars = carFactory.getCars();
        //then
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("차량 생성 실패")
    @Nested
    class CreateCarsFaild {
        @DisplayName("차량 이름이 5글자 이상일때")
        @Test
        public void 차량_이름이_5글자_이상일때() {
            //given
            setUp();
            List<String> carName = List.of("pobids");
            //when
            //then
            assertThatThrownBy(() -> carFactory.participants(carName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 5자를 초과 할 수 없습니다.");
        }

        @DisplayName("차량 이름이 0글자 일때")
        @Test
        public void 차량_이름이_0글자_일때() {
            //given
            setUp();
            List<String> carName = List.of("pobi","","honux");
            //when
            //then
            assertThatThrownBy(() -> carFactory.participants(carName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름이 없는 경우가 있습니다.");
        }
    }
}
