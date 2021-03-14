package carRacing.domain;

import carRacing.dto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    private Judge judge;

    @BeforeEach
    void setUp() {
        this.judge = new Judge();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2:false",
            "2:false",
            "3:false",
            "0:true"}, delimiter = ':')
    @DisplayName("게임 오버 상황을 판단할 수 있다")
    void isGameOverDeterminingGameOver(int numberOfRace, boolean expected) {
        UserInput userInput = new UserInput("test", numberOfRace);
        assertThat(judge.isGameOver(userInput)).isEqualTo(expected);
    }

    @Test
    @DisplayName("심판의 시간 카운트를 1씩 증가시킬 수 있다")
    void recordTimeIncreasesTimeCount() {
        for (int count = 1; count <= 100; count++) {
            judge.recordTime();
            assertThat(judge.isCount(count)).isTrue();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "player1:1:player2:2:player2",
            "player1:1:player2:1:player1,player2"}, delimiter = ':')
    @DisplayName("심판은 승자를 가릴 수 있다")
    void findWinnersFindsWinner(String player1Name, int player1Score, String player2Name, int player2Score, String expectedWinners) {
        Car car1 = new Car(player1Name, player1Score);
        Car car2 = new Car(player2Name, player2Score);

        assertThat(judge.findWinners(Arrays.asList(car1, car2)))
                .containsExactly(expectedWinners.split(","));
    }

}
