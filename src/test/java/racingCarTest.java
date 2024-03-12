import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Car;
import racingcar.Racingcar;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class racingCarTest {

    @Test
    @DisplayName("0~9 사이의 랜덤값을 구하는 테스트")
    public void testRandom() {
        int randomValue = Racingcar.getRandomValue();
        assertThat(randomValue < 10).isTrue();
    }

    @ParameterizedTest
    @DisplayName("4이상일 경우 전진하는 조건인지 테스트")
    @CsvSource({"3,false", "5,true", "8,true"})
    public void testIsMoving(int input, boolean output) {
        boolean isMoving = Racingcar.isMovingForward(input);
        assertThat(isMoving).isEqualTo(output);
    }

    @Test
    @DisplayName("자동차가 전진 기록 남기고 있는지 확인하는 테스트")
    public void testIsMovingCar() {
        Car car = new Car();
        car.move(true);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임 로직 정상실행 통합 테스트")
    public void testGameLogic() {
        Racingcar.gameLogic(3,5);
    }

    @Test
    @DisplayName("최대 입력값 초과 테스트")
    public void testMaxInput() {
        boolean isMaxInput = Racingcar.isMaximumInput(10001,10001);
        assertThat(isMaxInput).isTrue();
    }

}
