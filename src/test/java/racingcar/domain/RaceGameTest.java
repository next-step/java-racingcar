package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.AlreadyTerminateRaceGameException;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RaceGameTest {


    @DisplayName("RaceGame 인스턴스 생성 테스트")
    @ParameterizedTest
    @MethodSource("createCarNames")
    public void createRaceGameInstance(String[] carNames) {
        //Given & When
        RaceGame raceGame = new RaceGame(carNames, 3, new RandomCommander());

        //Then
        assertThat(raceGame).isNotNull();
    }

    static Stream<Arguments> createCarNames() {
        return Stream.of(
                Arguments.of((Object) new String[]{"테슬라", "현대", "크라이슬러", "닷지"}),
                Arguments.of((Object) new String[]{"기아", "볼보", "포르쉐"})
        );
    }

    @DisplayName("게임이 종료됬는데 게임을 시작하려고 할 경우 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 7})
    public void alreadyTerminateRaceGameException(int totalRound) {
        String[] carNames = {"테슬라", "현대", "크라이슬러", "닷지"};
        assertThatExceptionOfType(AlreadyTerminateRaceGameException.class)
                .isThrownBy(() -> {

                    RaceGame raceGame = new RaceGame(carNames, totalRound, new RandomCommander());

                    IntStream.range(0, totalRound).forEach(i -> raceGame.start());

                    raceGame.start();

                }).withMessage("이미 레이스가 종료된 게임입니다. 게임을 시작할 수 없습니다.");
    }


    @DisplayName("우승자 확인 테스트")
    @ParameterizedTest
    @MethodSource("createCarNames")
    public void getWinnerTest(String[] carNames) {

        //Given
        int totalRound = 3;
        RaceGame raceGame = new RaceGame(carNames, totalRound, new RandomCommander());

        //When
        RacingCars cars = null;
        for (int i = 0; i < totalRound; i++) {
            cars = raceGame.start();
        }
        List<String> winner = cars.getWinner();

        //Then
        assertThat(winner.size()).isGreaterThan(0);


    }

    @DisplayName("한 라운드 결과 테스트")
    @ParameterizedTest
    @MethodSource("createCarNames")
    public void getResult(String[] carNames) {

        //Given
        int totalRound = 3;
        RaceGame raceGame = new RaceGame(carNames, totalRound, new RandomCommander());

        //When
        RacingCars cars = raceGame.start();
        List<Integer> result = cars.getResult();

        //Then
        assertThat(result).hasSize(carNames.length);
    }

    @DisplayName("모든 라운드를 소진하는 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("createCarNames")
    public void isAllRoundFinishTest(String[] carNames){

        //Given
        int totalRound = 10;
        RaceGame raceGame = new RaceGame(carNames, totalRound, new RandomCommander());

        //When
        IntStream.range(0, totalRound)
                .forEach(i -> raceGame.start());

        //Then
        assertThat(raceGame.hasRemainRounds()).isTrue();
    }

}
