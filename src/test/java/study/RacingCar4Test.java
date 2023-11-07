package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar4.model.Car;
import racingcar4.model.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;
public class RacingCar4Test {

    @DisplayName("랜덤 값이 4이상일 때 한칸 전진한다.")
    @Test
    void moveCar() {
        Car car = new Car("name");
        car.forwardOneStep(car.canMove(4));
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 4미만일 때 움직이지 않는다.")
    @Test
    void stopCar() {
        Car car = new Car("name");
        car.forwardOneStep(car.canMove(3));
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 이름을 잘 갖고온다.")
    @Test
    void nameCar() {
        Car car = new Car("shy");
        assertThat(car.getName()).isEqualTo("shy");
    }

    @DisplayName("글자가 5글자가 넘으면 ERROR 발생")
    @Test
    void overNameLength() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingGame("mimimi,mm")).withMessage("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("최고 값을 잘 구분하는지 테스트")
    @Test
    void maxNum() {
        RacingGame racingGame = new RacingGame("mm,nn");
        assertThat(racingGame.calculatorPosition(5,4)).isEqualTo(5);
    }

    @DisplayName("이름 중복 제거")
    @Test
    void removeOverlap() {
        RacingGame racingGame = new RacingGame("mm,mm");
        String[] names = {"mm", "mm"};
        String[] testName = {"mm"};
        assertThat(racingGame.removeOverlap(names)).isEqualTo(testName);
    }

    @DisplayName("콤마를 기준으로 잘 split하는지")
    @Test
    void removeComma() {
        RacingGame racingGame = new RacingGame("mm,ll");
        String[] names = {"mm", "nn"};
        assertThat(racingGame.splitNames("mm,nn")).isEqualTo(names);
    }
}
