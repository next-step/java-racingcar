package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarCollection;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarCollectionTest {
    private CarCollection carCollection;
    private final List<String> DEFAULT_CAR_NAME = List.of("pobi","crong","honux");

    public void setUp() {
        this.carCollection = new CarCollection();
    }

    @DisplayName("차량이름으로 차량생성")
    @Test
    public void 차량이름으로_차량생성() {
        //given
        setUp();
        //when
        carCollection.participants(DEFAULT_CAR_NAME);
        List<Car> cars = carCollection.getCars();
        //then
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("차량 생성 후 이동값 4 부여, 1칸이동")
    @Test
    public void 차량_생성_후_이동값_4_부여_1칸이동() {
        //given
        setUp();
        carCollection.participants(DEFAULT_CAR_NAME);
        //when
        carCollection.moveCars(new FixtureMoveStrategy(4));
        List<Car> cars = carCollection.getCars();
        //then
        assertThat(cars.get(0).position()).isEqualTo(1);
        assertThat(cars.get(1).position()).isEqualTo(1);
        assertThat(cars.get(2).position()).isEqualTo(1);
    }

    @DisplayName("차량 생성 후 이동값 3 부여, 0칸이동")
    @Test
    public void 차량_생성_후_이동값_3_부여_0칸이동() {
        //given
        setUp();
        carCollection.participants(DEFAULT_CAR_NAME);
        //when
        carCollection.moveCars(new FixtureMoveStrategy(3));
        List<Car> cars = carCollection.getCars();
        //then
        assertThat(cars.get(0).position()).isEqualTo(0);
        assertThat(cars.get(1).position()).isEqualTo(0);
        assertThat(cars.get(2).position()).isEqualTo(0);
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
            assertThatThrownBy(() -> carCollection.participants(carName))
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
            assertThatThrownBy(() -> carCollection.participants(carName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름이 없는 경우가 있습니다.");
        }
    }
}
