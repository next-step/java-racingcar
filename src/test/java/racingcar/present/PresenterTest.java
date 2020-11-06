package racingcar.present;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.RaceGameContract;
import racingcar.model.GameRound;
import racingcar.model.RaceGame;
import racingcar.model.RandomCommander;
import racingcar.view.RenderingView;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PresenterTest {



    @DisplayName("레이스 게임 시작 및 종료 확인을 위한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3, 5", "5, 3", "10, 2", "2, 6"})
    public void gameStartTest(int participantCar, int round) {
        //Given
        RenderingView renderingView = new RenderingView();
        RaceGame game = new RaceGame(new GameRound(participantCar, round), new RandomCommander());
        RaceGameContract.Presenter presenter = new Presenter(renderingView, game);


        //When
        IntStream.range(0, round)
                .forEach(i -> presenter.gameStart());
        int result = renderingView.getExecuteCount();

        //Then
        assertThat(result).isEqualTo(round);

    }

}
