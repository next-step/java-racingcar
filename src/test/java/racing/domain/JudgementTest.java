package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgementTest {

    private Judgement judgement;
    private List<String> winners;

    @BeforeEach
    void setUp() {
        List<CarResult> lastRoundResult = new ArrayList<>();
        lastRoundResult.add(new CarResult("eohae", 8));
        lastRoundResult.add(new CarResult("eo", 8));
        lastRoundResult.add(new CarResult("a", 7));
        lastRoundResult.add(new CarResult("b", 4));

        judgement = new Judgement(lastRoundResult);
        winners = new ArrayList<>(Arrays.asList("eohae", "eo"));
    }

    @Test
    void 거리가_큰_순으로_wineer를_판별한다() {
        assertThat(judgement.judgeWinner())
            .isEqualTo(winners);
    }
}
