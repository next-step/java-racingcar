package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class RacingGameTest {

    @DisplayName("입력 받은 값 만큼 차를 생성하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 10})
    void makeCarTest(int numOfCar) {
        RacingGame.makeCars(numOfCar);
        assertThat(RacingGame.carList).hasSize(numOfCar);
    }
}
