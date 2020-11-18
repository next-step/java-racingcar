package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final int MOVABLE = 1;
    private static final int NON_MOVABLE = 0;
    private static final Position DIFFERENT_POSITION = new Position(1);
    private static final Position DEFAULT_POSITION = new Position(0);

    @Test
    @DisplayName("Name이 다른 객체일때 false를 반환한다")
    void should_return_false_when_Name_are_not_equal() {
        //Given
        Name name = new Name("damas");
        Car car = new Car(name);

        //When & Then
        Name anotherName = new Name("bmw");
        boolean result = car.equals(new Car(anotherName));
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Position이 다른 객체일때 false를 반환한다")
    void should_return_false_when_position_are_not_equal() {
        //Given
        Name name = new Name("damas");
        Car car = new Car(name, DEFAULT_POSITION);

        //When & Then
        Name anotherName = new Name("bmw");
        boolean result = car.equals(new Car(anotherName, DIFFERENT_POSITION));
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isMovable이 true이면, 자동차가 움직인다")
    void should_move_cars() {
        //Given
        Name name = new Name("damas");
        Car car = new Car(name);

        //When
        Car movingCar = car.move(() -> true);

        //Then
        assertThat(movingCar.getPosition().getValue()).isEqualTo(MOVABLE);
    }


    @Test
    @DisplayName("isMovable이 false이면, 자동차는 움직이지 않는다")
    void should_not_move_cars() {
        //Given
        Name name = new Name("damas");
        Car car = new Car(name);

        //When
        Car nonMovingCar = car.move(() -> false);

        //Then
        assertThat(nonMovingCar.getPosition().getValue()).isEqualTo(NON_MOVABLE);
    }

}