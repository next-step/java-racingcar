import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameManagementTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void createRacingCarTest() {
        //given
        final int testMove = 3;
        RacingCar car = new RacingCar();

        //when
        car.setMove(testMove);

        //then
        Assertions.assertThat(car.getMove()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 대회 게임 생섣 테스트")
    void createRacingCarGameManagementTest() {
        //given
        int numberOfCars = 3;
        int numberOfGames = 6;

        //when
        RacingCarGameManagement carGameManagement = new RacingCarGameManagement(numberOfCars, numberOfGames);

        //then
        Assertions.assertThat(carGameManagement.getGames()).isEqualTo(numberOfGames);
        Assertions.assertThat(carGameManagement.getCars()).hasSize(numberOfCars);
    }
}
