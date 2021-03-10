package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.module.GameManager;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    @DisplayName("게임 횟수 만큼 Car 객체 생성 크기 비교")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void carInstanceLength(int input, int result) {
        //GIVE
        GameManager gameManager = new GameManager();
        //WHEN

        //THEN
        assertThat(gameManager.countOfRound(input).getCars()).hasSize(result);
    }
}
