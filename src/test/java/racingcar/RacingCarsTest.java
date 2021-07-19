package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class RacingCarsTest {
    private ArrayList<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
    }

    @Test
    void 정적_팩토리_테스트() throws Exception {
        // given
        Class<RacingCars> expected = RacingCars.class;

        // when
        RacingCars actual = RacingCars.from(carList);

        // then
        Assertions.assertThat(actual).isNotNull().isInstanceOf(expected);
    }

    @Test
    void 조회_테스트() throws Exception {
        // given
        String name = "siro";
        String position = "-";
        carList.add(Car.of(name, position));

        // when
        String actualName = RacingCars.from(carList).getNameByIndex((0));
        String actualPosition = RacingCars.from(carList).getPositonByIndex((0));

        // then
        Assertions.assertThat(actualName).isEqualTo(name);
        Assertions.assertThat(actualPosition).isEqualTo(position);
    }

    @Test
    void 전진_테스트_조건은_참() throws Exception {
        // given
        String name = "siro";
        String position = "-";
        String expectedPosition = "--";
        carList.add(Car.of(name, position));

        // when
        RacingCars.from(carList).goForward(0, 4);
        String actualName = RacingCars.from(carList).getNameByIndex((0));
        String actualPosition = RacingCars.from(carList).getPositonByIndex((0));

        // then
        Assertions.assertThat(actualName).isEqualTo(name);
        Assertions.assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @Test
    void 전진_테스트_조건은_거짓() throws Exception {
        // given
        String name = "siro";
        String position = "-";
        Car expected = Car.of(name, position);
        carList.add(expected);

        // when
        RacingCars.from(carList).goForward(0, 3);
        String actualName = RacingCars.from(carList).getNameByIndex((0));
        String actualPosition = RacingCars.from(carList).getPositonByIndex((0));

        // then
        Assertions.assertThat(actualName).isEqualTo(name);
        Assertions.assertThat(actualPosition).isEqualTo(position);
    }

    @Test
    void 크기_조회_테스트() throws Exception {
        // given
        int expected = 3;
        carList.add(Car.of("siro1", "-"));
        carList.add(Car.of("siro2", "-"));
        carList.add(Car.of("siro3", "-"));

        // when
        int actual = RacingCars.from(carList).size();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
