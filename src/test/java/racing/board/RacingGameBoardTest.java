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
    public void test_게임_시작_랜덤_우승() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        RacingGameBoard board = new RacingGameBoard();
        board.createCars(carNames);

        GameResult result = board.start(5);

        assertThat(result.getWinners().size())
                .isGreaterThan(0)
                .isLessThanOrEqualTo(carNames.size());
    }

    @Test
    public void test_게임_시작_전체_우승() {
        List<String> winnerNames = Arrays.asList("pobi", "crong", "honux");
        RacingGameBoard board = new RacingGameBoard(() -> RacingCar.THRESHOLD_POWER);
        board.createCars(winnerNames);

        GameResult result = board.start(5);

        assertThat(result.getWinners().size())
                .isEqualTo(winnerNames.size());
    }
}