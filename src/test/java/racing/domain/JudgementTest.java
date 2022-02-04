package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.service.Judgement;

class JudgementTest {

    private List<Car> cars;
    private MoveRule rule;
    private Judgement judgement;
    private List<String> winners;

    @BeforeEach
    void setUp() {
        rule = new MoveRule(4);
        cars = new ArrayList<>(
            Arrays.asList(
                new Car("eohae",6, rule),
                new Car("eo", 6, rule),
                new Car("hae", 1, rule),
                new Car("rim", 0, rule)
            )
        );
        judgement = new Judgement(cars);
        winners = new ArrayList<>(Arrays.asList("eohae", "eo"));
    }

    @Test
    void wineer_판별하기() {
        assertThat(judgement.judgeWinner())
            .isEqualTo(winners);
    }
}
