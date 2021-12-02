package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.Game.cars;

public class GameTest {

    InputView inputView = new InputView();
    Game game = new Game();

    @Test
    @DisplayName("경기 수 세팅 메소드 테스트")
    public void setRoundTest(){
        game.setRoundCount(5);
        assertThat(game.getRoundCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("차 대수 세팅 메소드 테스트")
    public void setCarsTest(){
        cars.createCars(3);
        assertThat(cars.getSize()).isEqualTo(3);
    }

    @ParameterizedTest
    public void 게임플레이(){
        int carCount = inputView.inputScanner();
        int roundCount = inputView.inputScanner();

        inputView.viewCountCarInputMessage();
        cars.createCars(carCount);
        inputView.viewCountCar();


        inputView.viewCountRoundInputMessage();
        game.setRoundCount(roundCount);
        inputView.viewCountRound();

        ResultView.viewResultMessage();

        for (int i = 0; i < roundCount; i++) {
            game.playRound();
        }
    }
}