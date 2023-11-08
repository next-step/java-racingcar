package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2", "3:4", "5:6"}, delimiter = ':')
    public void processTest(int carNumber, int tryCount) {
        MoveCarStatus moveCarStatus = new MoveCarStatus(carNumber);
        MoveCars moveCars = new MoveCars(tryCount, 4);
        moveCars.process(moveCarStatus, new ResultView(moveCarStatus.getResultMap()));
        assertThat(moveCarStatus.getResultMap().size()).isEqualTo(carNumber);
        moveCarStatus.getResultMap().forEach((integer1, integer2) -> {
            assertThat(integer2).isLessThanOrEqualTo(tryCount);
        });

    }

}