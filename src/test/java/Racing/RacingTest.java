package Racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"1|1", "1|2", "2|1", "3|5", "4|6", "6|7"}, delimiter = '|')
    void testRace(int countOfCar, int countOfStage) {
        // given
        // when
        String board = new Racing(countOfCar).run(countOfStage);
        // then
        String[] stages = board.split("\n\n");
        System.out.println(board);
        assertThat(stages.length).isEqualTo(countOfStage);
        for (String stage : stages) {
            String[] track = stage.split("\n");
            assertThat(track.length).isEqualTo(countOfCar);
        }
    }

}