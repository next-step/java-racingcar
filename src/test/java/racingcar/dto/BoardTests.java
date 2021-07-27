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
    void boardRecordTest() {
        Board board = new Board();
        List<Integer> firstRacingResult = new ArrayList<>(Arrays.asList(1, 1, 1));
        List<String> firstRacingCarNames = new ArrayList<>(Arrays.asList("pobi", "crong", "honux"));
        List<Integer> secondRacingResult = new ArrayList<>(Arrays.asList(1, 2, 2));
        List<String> secondRacingCarNames = new ArrayList<>(Arrays.asList("pobi", "crong", "honux"));

        board.record(firstRacingCarNames, firstRacingResult);
        board.record(secondRacingCarNames, secondRacingResult);

        List<List<String>> actualCarNames = board.getAllRecordsCarsNames();
        List<List<Integer>> actualAllRecords = board.getAllRecords();

        assertThat(actualCarNames.toString()).isEqualTo("[[pobi, crong, honux], [pobi, crong, honux]]");
        assertThat(actualAllRecords.toString()).isEqualTo("[[1, 1, 1], [1, 2, 2]]");
    }
}
