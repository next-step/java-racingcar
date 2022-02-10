package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.service.Judgement;
import racing.vo.CarResultVO;

class JudgementTest {

    private Judgement judgement;
    private List<String> winners;

    @BeforeEach
    void setUp() {
        List<CarResultVO> results = new ArrayList<>();
        results.add(new CarResultVO("eohae", 8));
        results.add(new CarResultVO("eo", 8));
        results.add(new CarResultVO("a", 7));
        results.add(new CarResultVO("b", 4));

        judgement = new Judgement(new RoundResult(results));
        winners = new ArrayList<>(Arrays.asList("eohae", "eo"));
    }

    @Test
    void wineer_판별하기() {
        assertThat(judgement.judgeWinner())
            .isEqualTo(winners);
    }
}
