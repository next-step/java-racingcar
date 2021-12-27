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

    @BeforeEach
    public void setUp() {
        car = new Car("testCar");
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


    @Test
    @DisplayName("라운드 결과를 올바르게 출력한다.")
    void show_round_result() {
        //given
        Car car = new Car("testCar", 4);

        //when
        String roundResult = car.roundResult();

        //then
        assertTrue(roundResult.contains(car.getName()));
        assertEquals(roundResult.chars().filter(ch -> ch == '-').count(), 4);

    }
}