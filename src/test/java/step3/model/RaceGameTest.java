package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceGameTest {

    @DisplayName("참가 차량 댓수에 맞는 RacingCar 인스턴스 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "3:5", "3:2", "5:2"}, delimiter = ':')
    public void makeRacingCar(int participantCar, int round) {
        //Given
        RaceGame raceGame = new RaceGame(new GameRound(participantCar, round), new RandomCommander());

        //When
        int resultCount = raceGame.nextRound().size();

        //Then
        assertThat(resultCount).isEqualTo(participantCar);
    }


    @DisplayName("라운드 결과 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:2:1", "4:2:2", "7:3:3", "5:2:4"}, delimiter = ':')
    public void nextRoundTest(int participantCar, int round, int index){
        //Given
        RaceGame raceGame = new RaceGame(new GameRound(participantCar, round), new RandomCommander());

        //When
        RacingCars cars = raceGame.nextRound();

        //Then
        assertThat(cars.getParticipantCar(index).getCommands()).isNotNull();
        assertThat(cars.getParticipantCar(index).getCommands().length()).isGreaterThan(0);
    }

}
