package test;

import core.Car;
import core.MoveAction;
import core.StopAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;
import view.ResultView;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class RacingGameTest {

    @DisplayName("레이싱 횟수 입력 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void 레이싱횟수검증(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.checkInputValue(input);
        });
    }

    @DisplayName("전진 테스트")
    @ParameterizedTest
    @MethodSource("createCar")
    void 전진테스트(Car car) {
            int beforePosition = car.position;
            car.move(new MoveAction().isMove(0));
            assertThat(car.position).isEqualTo(beforePosition+1);
    }

    @DisplayName("멈춤 테스트")
    @ParameterizedTest
    @MethodSource("createCar")
    void 멈춤테스트(Car car) {
        int beforePosition = car.position;
        car.move(new StopAction().isMove(0));
        assertThat(car.position).isEqualTo(beforePosition);
    }

    @DisplayName("전진 조건 테스트")
    @ParameterizedTest
    @MethodSource("createCar")
    void 전진조건테스트(Car car) {
        int beforePosition = car.position;
        car.carAction(5);
        assertThat(car.position).isEqualTo(beforePosition+1);
    }

    @DisplayName("레이싱 게임 결과 출력 테스트")
    @Test
    void 레이싱테스트() {
        Car car = new Car(2);
        String result = ResultView.getStringFromPosition(car);
        assertThat(result).isEqualTo("--");
    }

    private static Stream<Car> createCar() {
        return Stream.of(new Car(2),new Car(1));
    }


}
