package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.Position;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("getName()은 자동차 이름을 반환")
    @ParameterizedTest
    @ValueSource(strings = {"carA", "carB", "car!", "1car2"})
    void getName(String name) {
        Car carA = new Car(name);
        assertThat(carA.getName()).isEqualTo(name);
    }

    @DisplayName("getPosition()은 자동차 위치를 반환")
    @ParameterizedTest
    @CsvSource(value = {"carA,true,1", "carB,false,0"}, delimiter = ',')
    void getPosition(String name, Boolean shouldMove, Integer result) {
        Car car = new Car(name);
        car.run(() -> shouldMove);
        assertThat(car.getPosition()).isEqualTo(new Position(result));
    }

    @DisplayName("자동차A의 위치가 자동차B 보다 앞서면 1, 같으면 0, 뒤쳐지면 -1 반환")
    @ParameterizedTest
    @CsvSource(value = {"carA,true,carB,true,0", "carA,true,carB,false,1", "carA,false,carB,true,-1"}, delimiter = ',')
    void compareToTest(String nameA, Boolean moveA, String nameB, Boolean moveB, Integer result) {
        Car carA = new Car(nameA);
        carA.run(() -> moveA);
        Car carB = new Car(nameB);
        carB.run(() -> moveB);
        assertThat(carA.compareTo(carB)).isEqualTo(result);
    }

    @DisplayName("자동차의 이동횟수 초기값은 0")
    @Test
    void getPosition() {
        Car carA = new Car("carA");
        assertThat(carA.getPosition()).isEqualTo(new Position(0));
    }

    @DisplayName("전략에 따라 자동차 전진 또는 멈춤")
    @ParameterizedTest
    @MethodSource("provideSource")
    void carMoveForward(Boolean isMovable, Position expected) {
        Car carA = new Car("carA");
        carA.run(() -> isMovable);
        assertThat(carA.getPosition()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(true, new Position(1)),
                Arguments.of(false, new Position(0))
        );
    }

    @DisplayName("더 많이 이동한 자동차가 양수를 반환한다")
    @Test
    void carCompareTest() {
        Car carA = new Car("carA");
        carA.run(() -> true);
        Car carB = new Car("carB");
        assertThat(carA.compareTo(carB) > 0).isTrue();
    }
}