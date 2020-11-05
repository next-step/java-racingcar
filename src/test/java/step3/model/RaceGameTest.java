package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.exception.AlreadyTerminateRaceGameException;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RaceGameTest {




    @DisplayName("게임이 종료됬는데 게임을 시작하려고 할 경우 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:1", "4:2", "7:3", "5:1"}, delimiter = ':')
    public void alreadyTerminateRaceGameException(int participantCar, int round) {
        assertThatExceptionOfType(AlreadyTerminateRaceGameException.class)
                .isThrownBy(() -> {
                    RaceGame raceGame = new RaceGame(new GameRound(participantCar, round), new RandomCommander());
                    raceGame.start();
                    for (int i = 0; i < round; i++) {
                        raceGame.start();
                    }
                }).withMessage("이미 레이스가 종료된 게임입니다. 게임을 시작할 수 없습니다.");
    }


    @DisplayName("레이스 게임 스타트 후 모든 라운드를 소진하는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:1", "4:2", "7:3", "5:4"}, delimiter = ':')
    public void startCompletedEnd(int participantCar, int round) {
        //Given
        GameRound gameRound = new GameRound(participantCar, round);
        RaceGame raceGame = new RaceGame(gameRound, new RandomCommander());

        //When
        IntStream.range(0, round).forEach(i -> raceGame.start());


        //Then
        assertThat(gameRound.getRound()).isEqualTo(0);

    }
}
