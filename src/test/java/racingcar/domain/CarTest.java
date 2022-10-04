package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Car 클래스의 move 메서드의 전진하는 조건은 0 에서 9 사이의 random 값에서 random 값이 기준으로 삼은 값 이상일 경우이다.")
    @Test
    void move() {
        MoveCondition moveCondition = new RandomMoveCondition();
        Car car = new Car(moveCondition);

        int createNum = createRandom();

        if (isMovable(moveCondition, createNum)) {
            car.move(createNum);
            assertThat(car.getPosition()).isEqualTo(1);
        } else {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    private boolean isMovable(MoveCondition moveCondition, int createNum) {
        return moveCondition.isMovable(createNum);
    }

    private int createRandom() {
        return RandomGenerator.randomInt();
    }
}