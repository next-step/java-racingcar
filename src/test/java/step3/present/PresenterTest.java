package step3.present;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.RaceGame;
import step3.model.RandomCommander;
import step3.model.GameRound;
import step3.view.RenderingView;

import static org.assertj.core.api.Assertions.assertThat;

public class PresenterTest {


    @DisplayName("참가차량 랜덤명령 전달 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3, 5", "5, 3", "10, 2", "2, 6"})
    public void gameStartTest(int participantCar, int round) {
        //Given
        RenderingView renderingView = new RenderingView();
        Presenter presenter = new Presenter(renderingView, new RandomCommander());

        //When
        presenter.gameStart(new GameRound(participantCar, round));


        //Then
        assertThat(renderingView.getExecuteCount()).isEqualTo(round);

    }

}
