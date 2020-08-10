package mvc.domain.car;

import mvc.domain.dto.CarState;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int START_POINT = 1;
    private static final String name = "test";
    private final Car car = Car.createCar(name);

    @Test
    void Car_생성_테스팅() {
        //given
        String expectedName = name;
        int expectedPos = START_POINT;

        Car test = Car.createCar(expectedName);

        //when
        CarState state = test.getState();
        String actualName = state.getName();
        int actualPos = state.getPosition();

        //then
        assertThat(expectedName).isEqualTo(actualName);
        assertThat(expectedPos).isEqualTo(actualPos);
    }

    @Test
    void 연료주입에_따른_Car_전진_테스팅() {
        int fuel = 4;
        int previousPosition = car.getPosition();

        car.move(fuel);

        int actual = car.getPosition();
        int expected = previousPosition + 1;

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void 연료주입에_따른_Car_정지_테스팅() {
        int fuel = 1;
        int expected = car.getPosition();

        car.move(fuel);

        int actual = car.getPosition();

        assertThat(expected).isEqualTo(actual);
    }
}