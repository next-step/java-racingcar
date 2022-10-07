package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;
import racingcar.condition.MoveCondition;
import racingcar.condition.RandomMoveCondition;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private MoveCondition moveCondition;

    @BeforeEach
    public void setUp() {
        this.moveCondition = new RandomMoveCondition();
    }

    @Test
    void equals_max_position() {
        Car car = new Car("유민", 3);
        assertThat(car.hasMaxPosition(3)).isTrue();
    }

    @Test
    void get_maximum() {
        Car car = new Car("유민", 3);
        assertThat(car.comparePosition(4)).isEqualTo(4);
        assertThat(car.comparePosition(2)).isEqualTo(3);
    }

//    public Car
//    @DisplayName("Car 클래스의 move 메서드의 전진하는 조건은 0 에서 9 사이의 random 값에서 random 값이 기준으로 삼은 값 이상일 경우이다.")
//    @Test
//    void move() {
//        Car car = new Car(moveCondition);
//
//        if (moveCondition.isMovable()) {
//            car.move(moveCondition);
//            assertThat(car.getPosition()).isEqualTo(1);
//        } else {
//            assertThat(car.getPosition()).isEqualTo(0);
//        }
//    }

    private boolean isMovable(MoveCondition moveCondition) {
        return moveCondition.isMovable();
    }

    private int createRandom() {
        return RandomGenerator.randomInt();
    }
}
