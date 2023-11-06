package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarCollection;
import racingcar.domain.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCollectionTest {
    private CarCollection carCollection;
    private final List<String> DEFAULT_CAR_NAME = List.of("pobi", "crong", "honux");

    public void setUp(List<String> carName) {
        this.carCollection = new CarCollection(new CarFactory().participants(carName));
    }

    @DisplayName("차량이름으로 차량생성")
    @Test
    public void 차량이름으로_차량생성() {
        //given
        setUp(DEFAULT_CAR_NAME);
        //when
        List<Car> cars = carCollection.getCars();
        //then
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("차량 생성 후 이동값 4 부여, 1칸이동")
    @Test
    public void 차량_생성_후_이동값_4_부여_1칸이동() {
        //given
        setUp(DEFAULT_CAR_NAME);
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
        setUp(DEFAULT_CAR_NAME);
        //when
        carCollection.moveCars(new FixtureMoveStrategy(3));
        List<Car> cars = carCollection.getCars();
        //then
        assertThat(cars.get(0).position()).isEqualTo(0);
        assertThat(cars.get(1).position()).isEqualTo(0);
        assertThat(cars.get(2).position()).isEqualTo(0);
    }
}
