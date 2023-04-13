package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.gameobject.Car;
import step3.rule.StubbingTrueRule;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("각각의 차가 경주한 정도가 옳게 되었는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 10})
    public void plusTraceTest(int count) {
        String name = "TEST";
        Car car = new Car(name, new StubbingTrueRule());
        StringBuilder expected = new StringBuilder("-");

        for (int i = 0; i < count; i++) {
            car.goOrStop();
            expected.append("-");
        }

        assertThat(car.getNowRacingResult()).isEqualTo(name + " : " + expected);
    }

}