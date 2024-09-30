import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void createRacingCarTest() {
        //given
        final int testMove = 3;

        //when
        RacingCar car = new RacingCar(testMove);

        //then
        Assertions.assertThat(car.getStatus()).isEqualTo(3);
    }


    @Test
    @DisplayName("자동차 객체 생성 테스트 - 이름 추가")
    void createRacingCarTest_withName() {
        //given
        final int testMove = 3;
        final String testName = "hosop car";

        //when
        RacingCar car = new RacingCar(testMove, testName);

        //then
        Assertions.assertThat(car.getStatus()).isEqualTo(3);
        Assertions.assertThat(car.getName()).isEqualTo(testName);
    }
}
