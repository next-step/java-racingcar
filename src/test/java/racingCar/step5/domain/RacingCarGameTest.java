package racingCar.step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.step5.domain.dto.CarDto;
import racingCar.step5.domain.dto.RacingCarGameResult;
import racingCar.step5.domain.dto.WinnerDto;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarGameTest {

    private RacingCars cars;

    @BeforeEach
    void setUp() {
        cars = RacingCars.ofNames("1번,2번");
    }

    @DisplayName("레이싱 게임 실행 후, 실행 결과를 알 수 있다")
    @Test
    void showRacingCarGameResult(){
        RacingCarGame game = new RacingCarGame(cars, new RandomNumber(4));

        RacingCarGameResult gameResult = game.start();

        assertThat(gameResult.getRacingResults()).containsExactlyInAnyOrder(
                new CarDto("1번", 1)
                , new CarDto("2번", 1)
        );
    }

    @DisplayName("레이싱 게임 후, 우승자을 알 수 있다")
    @Test
    void getWinners(){
        RacingCarGame game = new RacingCarGame(cars, new RandomNumber(4));

        RacingCarGameResult gameResult = game.start();

        assertThat(gameResult.getWinners()).containsExactlyInAnyOrder(
                new WinnerDto("1번")
                , new WinnerDto("2번")
        );
    }
}