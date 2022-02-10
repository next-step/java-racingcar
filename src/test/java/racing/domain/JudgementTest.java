package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.service.Judgement;

class JudgementTest {

    private Judgement judgement;
    private List<String> winners;

    @BeforeEach
    void setUp() {
        List<CarResult> results = new ArrayList<>();
        results.add(new CarResult("eohae", 8));
        results.add(new CarResult("eo", 8));
        results.add(new CarResult("a", 7));
        results.add(new CarResult("b", 4));

        judgement = new Judgement(new RoundResult(results));
        winners = new ArrayList<>(Arrays.asList("eohae", "eo"));
    }

    @Test
    void wineer_판별하기() {
        assertThat(judgement.judgeWinner())
            .isEqualTo(winners);
    }
}
