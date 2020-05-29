package camp.nextstep.edu.nextstep8.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RacingGameTest {

    @Mock
    RacingCar racingCar;

    @Mock
    RacingGameInputView inputView;

    @Mock
    RacingGameStatusView statusView;

    @InjectMocks
    @Spy
    RacingGame racingGame = new RacingGame();

    @DisplayName("Play 가 수행 되었을 때 내부적 으로 호출 되는 method 가 잘 호출 되는지 확인")
    @Test
    public void playTest() {
        // given
        int carNumbers = 3;
        int raceTimes = 5;
        when(inputView.getCarNumbers()).thenReturn(carNumbers);
        when(inputView.getRoundTimes()).thenReturn(raceTimes);

        // when
        racingGame.play();

        // then
        verify(racingGame, times(1)).enrollAndGetParticipatedList(carNumbers);
        verify(racingGame, times(1)).raceStart(eq(raceTimes),any(List.class));
    }

    @DisplayName("자동차 대 수가 주어졌을 때 Race 참가 명단이 제대로 생성인 되는지 확인")
    @Test
    public void enrollAndGetParticipatedListTest() {
        // given
        int carNumbers = 3;

        // when
        List<RacingCar> participatedList = racingGame.enrollAndGetParticipatedList(carNumbers);

        // then
        assertThat(participatedList.size()).isEqualTo(carNumbers);
    }

    @DisplayName("Race 횟 수 만큼 경기가 제대로 실행 되는지 확")
    @Test
    public void raceStartTest() {
        // given
        int carNumbers = 3;
        int raceTimes = 5;
        List<RacingCar> participatedList = racingGame.enrollAndGetParticipatedList(carNumbers);

        // when
        racingGame.raceStart(raceTimes, participatedList);

        // then
        verify(statusView, times(raceTimes)).showRoundResult(anyList());
    }
}