package carracing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @ParameterizedTest(name = "랜덤 값이 4이상인 경우 전진한다.")
    @ValueSource(ints = {4, 7, 9})
    public void goTest(int randomNumber) {
        int positionBeforeMove = 0;
        Car car = Car.of(positionBeforeMove);
        car.move(RandomNumber.of(randomNumber));
        assertThat(car.getPosition())
                .matches(position -> position.equals(Position.of(positionBeforeMove + 1)));
    }

    @ParameterizedTest(name = "랜덤 값이 4미만인 경우 제자리에 위치한다.")
    @ValueSource(ints = {0, 2, 3})
    public void stopTest(int randomNumber) {
        int positionBeforeMove = 0;
        Car car = Car.of(positionBeforeMove);
        car.move(RandomNumber.of(randomNumber));
        assertThat(car.getPosition())
                .isEqualTo(Position.of(positionBeforeMove));
    }

}