package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

    @DisplayName("입력 받은 값 만큼 차를 생성하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 10})
    public void makeCarTest(int numberOfCars) {
        RacingGame.makeCars(numberOfCars);
        Assertions.assertThat(RacingGame.carList).hasSize(numberOfCars);
    }

    @AfterEach
    void afterEach() {
        RacingGame.carList.clear();
    }

}