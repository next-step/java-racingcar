package racing.board;

import org.junit.*;
import racing.model.RacingCar;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameBoardTest {

    @Test
    public void test_차_생성_1대() {
        RacingGameBoard board = new RacingGameBoard();
        assertThat(board.createCars(Arrays.asList("pobi")))
                .isEqualTo(1);
    }

    @Test
    public void test_차_생성_2대() {
        RacingGameBoard board = new RacingGameBoard();
        assertThat(board.createCars(Arrays.asList("pobi", "crong")))
                .isEqualTo(2);
    }

    @Test
    public void test_게임_시작_전체_우승() {
        // Given
        RacingGameBoard board = new RacingGameBoard(() -> RacingCar.THRESHOLD_POWER);
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        board.createCars(names);

        // When
        GameResult result = board.start(3);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.winners()).isEqualTo(names);
    }
}