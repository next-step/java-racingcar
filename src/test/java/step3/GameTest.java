package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    InputView inputView = new InputView();
    Game game = new Game(5);

    @Test
    @DisplayName("경기 수 세팅 메소드 테스트")
    public void setRoundTest(){
        assertThat(game.getRoundCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("차 대수 세팅 메소드 테스트")
    public void setCarsTest(){
        cars.createCars(3);
        assertThat(cars.getSize()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,5"})
    public void 게임플레이(int carCount, int roundCount){
        inputView.viewCountCarInputMessage();
        cars.createCars(carCount);
        inputView.viewCountCar();


        inputView.viewCountRoundInputMessage();
        inputView.viewCountRound();

        ResultView.viewResultMessage();

        for (int i = 0; i < roundCount; i++) {
            game.playRound();
        }
    }
}