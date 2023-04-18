package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    void MoveStrategy의_canMove가_true이면_자동차의_위치는_1_증가한다() {
        //GIVEN
        CarName carName = new CarName("a");
        MoveStrategy moveStrategy = new TestHelper.AlwaysMoveStrategy();
        Car car = new Car(carName, moveStrategy);
        assertThat(car.getPosition()).isEqualTo(0);

        //WHEN
        car.moveForward();

        //THEN
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void MoveStrategy의_canMove가_false이면_자동차의_위치는_0이다() {
        //GIVEN
        CarName carName = new CarName("a");
        MoveStrategy moveStrategy = new TestHelper.NeverMoveStrategy();
        Car car = new Car(carName, moveStrategy);
        assertThat(car.getPosition()).isEqualTo(0);

        //WHEN
        car.moveForward();

        //THEN
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest(name = "자동차의 이동 전략이 {0}이고 2번 움직이면 위치는 {1}이다")
    @MethodSource("getCarPositionTestStubs")
    void 자동차가_움직이면_위치가_변한다(MoveStrategy moveStrategy, int position) {
        CarName carName = new CarName("a");
        Car car = new Car(carName, moveStrategy);
        car.moveForward();
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @ParameterizedTest(name = "자동차의 이름인 {0}을 확인할 수 있다.")
    @ValueSource(strings = {"a", "bc", "def1"})
    void 자동차의_이름을_확인할_수_있다(String name) {
        CarName carName = new CarName(name);
        Car car = new Car(carName, new TestHelper.AlwaysMoveStrategy());
        assertThat(car.getCarName()).isEqualTo(name);
    }

    private static Stream<Arguments> getCarPositionTestStubs() {
        return Stream.of(
                Arguments.arguments(new TestHelper.AlwaysMoveStrategy(), 2),
                Arguments.arguments(new TestHelper.NeverMoveStrategy(), 0)
        );
    }
}
