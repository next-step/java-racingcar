package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        this.racingCar = new RacingCar();
    }

    @DisplayName("move 함수 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 8, 6, 9})
    void moveTest(int count){
        for (int i = 0; i < count ; i++) {
            racingCar.move();
        }
        assertThat(racingCar.currentPosition()).isEqualTo(count);
    }

}
