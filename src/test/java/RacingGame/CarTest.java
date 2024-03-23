package RacingGame;

import RacingGame.testClass.FixNumberGenerator;
import RacingGame.model.Car;
import RacingGame.model.MovableStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("차량의 초기 위치는 0")
    void carInitialValueTest() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("차량의 전진 기능 테스트")
    void moveCarTest() {
        MovableStrategy movableStrategy = new MovableStrategy(new FixNumberGenerator(9));

        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(movableStrategy);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜던값이 1~3은 정지, 4~9는 전진 기능 테스트")
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void carMoveConditionTest(int value, int expected) {
        MovableStrategy movableStrategy = new MovableStrategy(new FixNumberGenerator(value));

        Car car = new Car();
        car.move(movableStrategy);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @Test
    @DisplayName("차량에게 부여한 이름으로 생성한 차량의 이름은 부여한 이름과 같다.")
    void carNameTest() {
        String name = "황제원";
        Car car = new Car(name);

        assertThat(car.name()).isEqualTo(name);
    }

    @Test
    @DisplayName("차량에게 부여한 이름이 5글자 초과시 예외 발생 ")
    void nameRuleTest() {
        String name = "황제드라몬 파이터 모드";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량의 이름은 5 글자가 넘어갈 수 없습니다");
    }
}
