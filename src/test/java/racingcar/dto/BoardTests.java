package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingGame;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTests {
    @DisplayName("기록판에 기록이 잘 입력되는지 테스트")
    @Test
    void boardRecordTest(){
        Board board = new Board();
        List<Integer> firstRacingResult = new ArrayList<>(Arrays.asList(1,1,1));
        List<Integer> secondRacingResult = new ArrayList<>(Arrays.asList(1,2,2));

        board.record(firstRacingResult);
        board.record(secondRacingResult);

        List<List<Integer>> expected = board.getAllRecords();

        assertThat("[[1, 1, 1], [1, 2, 2]]").isEqualTo(expected.toString());
    }
}
