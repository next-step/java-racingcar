package racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.exception.InvalidCarNumberException;
import racinggame.exception.InvalidDistanceNumberException;
import racinggame.exception.InvalidGameNumberException;

class ScoreBoardTest {

    private static final int NUM_OF_GAME = 3;
    private static final int NUM_OF_CAR = 4;

    @Test
    @DisplayName("주어진 스코어보드에서 원하는 차량의 원하는 경기 회차의 결과인 주행거리 확인 테스트")
    void get_distance_of_my_car() {
        ScoreBoard scoreBoard = getDefaultGameScoreBoard();

        int distance = 3;
        scoreBoard.setDistance(distance, NUM_OF_GAME, NUM_OF_CAR);

        assertThat(scoreBoard.getDistance(NUM_OF_GAME, NUM_OF_CAR)).isEqualTo(3);

    }

    @Test
    @DisplayName("주어진 스코어보드에서 잘못된 차량의 원하는 경기 회차의 결과인 주행거리 확인 시 예외 발생 테스트")
    void get_distance_of_wrong_car() {
        ScoreBoard scoreBoard = getDefaultGameScoreBoard();

        int invalidCarNumber = NUM_OF_CAR + 1;

        assertThatThrownBy(() -> scoreBoard.getDistance(NUM_OF_GAME, invalidCarNumber))
                .isInstanceOf(InvalidCarNumberException.class);

    }

    @Test
    @DisplayName("주어진 스코어보드에서 원하는 차량의 잘못된 경기 회차의 결과인 주행거리 확인 시 예외 발생 테스트")
    void get_distance_of_wrong_game() {
        ScoreBoard scoreBoard = getDefaultGameScoreBoard();

        int invalidGameNumber = NUM_OF_GAME + 1;

        assertThatThrownBy(() -> scoreBoard.getDistance(invalidGameNumber, NUM_OF_CAR))
                .isInstanceOf(InvalidGameNumberException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:3:2:2", "3:4:1:1", "2:1:0:0"}, delimiter = ':')
    @DisplayName("스코어보드에 이번 경기 원하는 차량의 거리 기록 테스트")
    void set_distance_of_my_car(int gameNumber, int carNumber, int distance, int expected) {
        ScoreBoard scoreBoard = getDefaultGameScoreBoard();

        scoreBoard.setDistance(distance, gameNumber, carNumber);

        assertThat(scoreBoard.getDistance(gameNumber, carNumber)).isEqualTo(expected);
    }

    @Test
    @DisplayName("스코어보드에 잘못된 경기 회차에 거리 기록 시 예외 발생 테스트")
    void set_distance_of_invalid_game() {
        ScoreBoard scoreBoard = getDefaultGameScoreBoard();
        int invalidGameNumber = NUM_OF_GAME + 1;
        int validDistance = 3;

        assertThatThrownBy(() -> scoreBoard.setDistance(validDistance, invalidGameNumber,
                NUM_OF_CAR))
                .isInstanceOf(InvalidGameNumberException.class);
    }

    @Test
    @DisplayName("스코어보드에 잘못된 차량에 거리 기록 시 예외 발생 테스트")
    void set_distance_of_invalid_car() {
        ScoreBoard scoreBoard = getDefaultGameScoreBoard();
        int invalidCarNumber = NUM_OF_CAR + 1;
        int validDistance = 3;

        assertThatThrownBy(
                () -> scoreBoard.setDistance(validDistance, NUM_OF_GAME, invalidCarNumber))
                .isInstanceOf(InvalidCarNumberException.class);
    }

    @Test
    @DisplayName("스코어보드에 잘못된 거리 기록 시 예외 발생 테스트")
    void set_distance_of_invalid_distance() {
        ScoreBoard scoreBoard = getDefaultGameScoreBoard();
        int invalidDistance = -3;

        assertThatThrownBy(() -> scoreBoard.setDistance(invalidDistance, NUM_OF_GAME, NUM_OF_CAR))
                .isInstanceOf(InvalidDistanceNumberException.class);
    }

    private ScoreBoard getDefaultGameScoreBoard() {
        return new ScoreBoard(NUM_OF_GAME, NUM_OF_CAR);
    }

}