package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {

    private static final String TESTER_NAME = "Kim";
    private static final String INVALID_TESTER_NAME = "KimBaeMin";
    private static final String MARK = "-";

    @Test
    @DisplayName("이름이 5자를 초과할 경우, 에러 발생")
    void CarConstructor__ShouldReturnException() {
        assertThatThrownBy(() -> new Car(INVALID_TESTER_NAME))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid Name : " + INVALID_TESTER_NAME);
    }

    @Test
    @DisplayName("RandomMovementStrategy의 movable이 false인 경우, 자동차는 움직이지 않음")
    void RandomMovementStrategy__ShouldNotMove() {
        // given
        CarMovementStrategy carMovementStrategy = () -> false;
        Car car = new Car(TESTER_NAME);

        // when
        car.move(carMovementStrategy);

        // then
        assertThat(car.getPosition(MARK)).isEqualTo("");
    }

    @Test
    @DisplayName("RandomMovementStrategy의 movable이 true인 경우, 자동차는 움직임")
    void RandomMovementStrategy__ShouldMove() {
        // given
        CarMovementStrategy carMovementStrategy = () -> true;
        Car car = new Car(TESTER_NAME);

        // when
        car.move(carMovementStrategy);

        // then
        assertThat(car.getPosition(MARK)).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차의 점수가 maxScore 이상일 경우, isWinner는 true")
    void isWinner__ShouldReturnTrue() {
        // given
        int maxScore = 0;

        // when
        Car car = new Car(TESTER_NAME);

        // then
        assertThat(car.isWinner(maxScore)).isTrue();
    }

    @Test
    @DisplayName("자동차의 점수가 maxScore 이상일 경우, maxScore는 자동차의 점수로 갱신됨")
    void getScoreGreaterThan__ShouldReturnCarScore() {
        // given
        int maxScore = 0;
        CarMovementStrategy carMovementStrategy = () -> true;

        // when
        Car car = new Car(TESTER_NAME);
        car.move(carMovementStrategy);

        // then
        assertThat(car.getScoreGreaterThan(maxScore)).isEqualTo(1);
    }
}
