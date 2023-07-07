package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameBoardTest {

    @Test
    @DisplayName("우승자의 이름들을 반환한다.")
    void GameBoardTest_winnerTest() {
        List<Car> cars = List.of(
                new Car(new CarName("pobi"), new Position(4)),
                new Car(new CarName("honux"), new Position(5)),
                new Car(new CarName("zzuni"), new Position(5))
        );
        GameBoard gameBoard = new GameBoard(cars);

        List<String> winners = gameBoard.getWinnerNames().getNames();
        Assertions.assertThat(winners).contains("honux", "zzuni");
    }
}
