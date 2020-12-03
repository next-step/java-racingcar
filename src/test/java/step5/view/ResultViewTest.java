package step5.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.domain.Car;
import step5.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    private ResultView resultView;

    @BeforeEach
    void create_result_view_instance() {
        resultView = new ResultView();
    }

    @ParameterizedTest
    @DisplayName("자동차 경주 게임의 우승자가 제대로 출력되는지 테스트")
    @CsvSource(value = {"kia,bmw,audi:kia", "xm3,kona,venue:xm3"}, delimiter = ':')
    void print_valid_winner(String carNames, String expected) {
        RacingGame racingGame = new RacingGame(carNames.split(","), 3);
        List<Car> carList = racingGame.getCars();

        carList.get(0).move(7);
        carList.get(0).move(5);
        carList.get(0).move(4);

        carList.get(1).move(3);
        carList.get(1).move(2);
        carList.get(1).move(1);

        carList.get(2).move(1);
        carList.get(2).move(2);
        carList.get(2).move(5);

        assertThat(ResultView.getStringOfWinner(racingGame.getWinners())).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("자동차 경주 게임의 다수의 우승자가 제대로 출력되는지 테스트")
    @CsvSource(value = {"kia,bmw,audi,jeep:kia, bmw", "xm3,kona,venue,niro:xm3, kona"}, delimiter = ':')
    void print_valid_multiple_winners(String carNames, String expected) {
        RacingGame racingGame = new RacingGame(carNames.split(","), 3);
        List<Car> carList = racingGame.getCars();

        carList.get(0).move(7);
        carList.get(0).move(5);
        carList.get(0).move(4);

        carList.get(1).move(7);
        carList.get(1).move(7);
        carList.get(1).move(7);

        carList.get(2).move(1);
        carList.get(2).move(2);
        carList.get(2).move(5);

        carList.get(3).move(1);
        carList.get(3).move(1);
        carList.get(3).move(1);

        assertThat(ResultView.getStringOfWinner(racingGame.getWinners())).isEqualTo(expected);
    }
}