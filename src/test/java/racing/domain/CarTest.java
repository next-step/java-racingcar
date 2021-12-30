package racing.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.MovableValueMovingStrategy;
import racing.utils.MovingStrategy;
import racing.utils.UnmovableValueMovingStrategy;

class CarTest {

    private Car car;

    private static final String NAME_LENGTH_EXCEPTION = "자동차 이름은 5자 이하여야 합니다.";
    private static final String BLANK_NAME_EXCEPTION = "자동차 이름 값은 존재해야 합니다.";


    @BeforeEach
    public void setUp() {
        car = new Car("test");
    }

    @Test
    @DisplayName("이름이 6글자 이상이면 IllegalStateException을 발생시킨다.")
    void name_length_greater_than_six_is_invalid() {
        //given
        String name = "testCar";

        //when
        Exception exception = assertThrows(IllegalStateException.class, () -> new Car(name));

        //then
        assertEquals(exception.getMessage(), NAME_LENGTH_EXCEPTION);

    }

    @Test
    @DisplayName("이름이 존재하지 않으면 IllegalStateException을 발생시킨다.")
    void blank_name_is_invalid() throws IllegalStateException {
        //given
        String name = " ";

        //when
        Exception exception = assertThrows(IllegalStateException.class, () -> new Car(name));

        //then
        assertEquals(exception.getMessage(), BLANK_NAME_EXCEPTION);

    }

    @Test
    @DisplayName("랜덤 값이 4이상이면 위치 1을 증가시킨다.")
    void is_movable_with_number_greater_or_equal_than_four() {
        //given
        MovingStrategy movingStrategy = new MovableValueMovingStrategy();

        //when
        car.move(movingStrategy);

        //then
        assertEquals(car.getDistance(), 1);
    }


    @Test
    @DisplayName("랜덤 값이 3이하이면 움직이지 않는다.")
    void is_unmovable_with_number_less_than_four() {
        //given
        MovingStrategy movingStrategy = new UnmovableValueMovingStrategy();

        //when
        car.move(movingStrategy);

        //then
        assertEquals(car.getDistance(), 0);
    }

}