import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameManagementTest {
    @Test
    @DisplayName("자동차 대회 게임 생섣 테스트")
    void createRacingCarGameManagementTest() {
        //given
        int numberOfCars = 3;
        int numberOfGames = 6;
        MockRandomNumberGenerator generator = new MockRandomNumberGenerator(3);

        //when
        RacingCarGameManagement carGameManagement = new RacingCarGameManagement(numberOfCars, numberOfGames, generator);

        //then
        Assertions.assertThat(carGameManagement.getGames()).isEqualTo(numberOfGames);
        Assertions.assertThat(carGameManagement.getCars()).hasSize(numberOfCars);
        for (RacingCar car : carGameManagement.getCars()) {
            Assertions.assertThat(car.getStatus()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("전진 테스트")
    void carMoveCarsTest() {
        //given
        int[] moves = new int[]{1, 4, 9};
        RacingCar car = new RacingCar();

        //when
        for (int move : moves) {
            car.move(move);
        }

        //then
        Assertions.assertThat(car.getStatus()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 시작 테스트")
    void startGameTest() {
        //given
        int numberOfCars = 3;
        int numberOfGames = 6;
        MockRandomNumberGenerator generator = new MockRandomNumberGenerator(5);
        RacingCarGameManagement carGameManagement = new RacingCarGameManagement(numberOfCars, numberOfGames, generator);

        //when
        carGameManagement.start();

        //then
        Assertions.assertThat(carGameManagement.getGames()).isEqualTo(0);
        Assertions.assertThat(carGameManagement.getCars()).hasSize(numberOfCars);
        for (RacingCar car : carGameManagement.getCars()) {
            int move = car.getStatus();
            System.out.println(move);
            Assertions.assertThat(move).isEqualTo(6);
        }
    }
}
