package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car = new Car("testCar");

    @Test
    void 자동차는_이름으로_생성된다() {
        assertThat(car).isNotNull();
    }

    @Test
    void 생성된_자동차의_최초위치는_0이다() {
        assertThat(car.getPosition()).isEqualTo(Position.INITIAL_POSITION);
    }

    @Test
    void 주어진_랜덤숫자가_4이상이면_전진한다() {
        int positionBeforeMove = car.getPosition();
        car.move(Position.MOVE_CRITERION);

        assertThat(car.getPosition())
                .isEqualTo(positionBeforeMove + Position.DISTANCE_PER_MOVE);
    }

    @Test
    void 주어진_랜덤숫자가_4미만이면_정지한다() {
        int positionBeforeMove = car.getPosition();
        car.move(Position.MOVE_CRITERION - 1);

        assertThat(car.getPosition())
                .isEqualTo(positionBeforeMove);
    }

    @Test
    void 자동차가_전진하면_position이_1만큼_증가한다() {
        car.move(Position.MOVE_CRITERION);
        assertThat(car.getPosition()).isEqualTo(Position.DISTANCE_PER_MOVE);
    }
    //TODO: 질문이 있습니다-!
    //TODO: Q. 전진하면 position이 1 증가하는 테스트를 CarTest에서도 하고, PositionTest에서도 하는데 불필요한가요?
    //TODO: car.move()메서드는 position.move()메서드로 바로 넘겨주는 역할만 하니까 PositionTest에서만 테스트하면 될까요?
}
