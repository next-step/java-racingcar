package step3.present;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.GameRound;
import step3.model.RaceGame;
import step3.model.RandomCommander;
import step3.view.RenderingView;

import static org.assertj.core.api.Assertions.assertThat;

public class PresenterTest {


    private RenderingView renderingView = new RenderingView();
    private Presenter presenter = new Presenter(renderingView, new RandomCommander());

    @DisplayName("RaceGame 인스턴스 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3, 5", "5, 3", "10, 2", "2, 6"})
    public void createRaceGameTest(int participantCar, int round) {
        //Given & When
        RaceGame game = presenter.createGame(new GameRound(participantCar, round));

        //Then
        assertThat(game).isNotNull();

    }


    @DisplayName("레이스 게임 시작 및 종료 확인을 위한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3, 5", "5, 3", "10, 2", "2, 6"})
    public void gameStartTest(int participantCar, int round) {
        //Given
        RaceGame game = presenter.createGame(new GameRound(participantCar, round));

        //When


        //Then
        assertThat(renderingView.getExecuteCount()).isEqualTo(round);

    }

}
