package camp.nextstep.edu.racingcar.result;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundResultTest {

    @Test
    @DisplayName("가장 많이 이동한 우승자의 목록을 반환한다")
    void getWinners() {
        // given
        RoundResult roundResult = new RoundResult();
        roundResult.report(new DriveResult("win1", 3));
        roundResult.report(new DriveResult("win2", 3));
        roundResult.report(new DriveResult("lose", 0));
        roundResult.report(new DriveResult("lose", 1));
        roundResult.report(new DriveResult("lose", 2));

        // when
        List<String> winners = roundResult.getWinners();

        // then
        assertThat(winners).containsExactly("win1", "win2");
    }
}
