package racing.board;

import org.junit.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameBoardTest {

    @Test
    public void test_차_생성() {
        int size = 3;
        RacingGameBoard board = new RacingGameBoard();
        assertThat(board.createCars(size))
                .isEqualTo(size);
    }

    @Test
    public void test_랜덤이동_0대_1회() {
        RacingGameBoard board = new RacingGameBoard();
        assertThat(board.moveCars())
                .isEqualTo(Collections.emptyList());
    }

    @Test
    public void test_랜덤이동_3대_1회() {
        RacingGameBoard board = new RacingGameBoard();
        int size = board.createCars(3);
        List<Integer> positions = board.moveCars();

        assertThat(positions.size())
                .isEqualTo(size);

        for (int position : positions) {
            assertThat(position).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    public void test_1칸이동_3대_3회() {
        RacingGameBoard board = new RacingGameBoard(() -> 10);
        int size = board.createCars(3);
        int time = 3;
        for (int position = 1; position <= time; position++) {
            assertThat(board.moveCars())
                    .isEqualTo(getPositions(size, position));
        }
    }

    @Test
    public void test_0칸이동_3대_3회() {
        RacingGameBoard board = new RacingGameBoard(() -> 3);
        int size = board.createCars(3);
        int time = 3;
        for (int positoin = 1; positoin <= time; positoin++) {
            assertThat(board.moveCars())
                    .isEqualTo(getPositions(size, 0));
        }
    }

    private List<Integer> getPositions(int size, int value) {
        return IntStream.range(0, size)
                .boxed()
                .map(i -> value)
                .collect(Collectors.toList());
    }
}