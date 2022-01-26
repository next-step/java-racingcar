package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgementTest {

    private List<Car> cars;
    private Judgement judgement;
    private List<String> winners;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>(
            Arrays.asList(
                new Car("eohaerim", 6),
                new Car("eo", 6),
                new Car("hae", 2),
                new Car("rim", 2)
            )
        );
        judgement = new Judgement(cars);
        winners = new ArrayList<>(Arrays.asList("eohaerim", "eo"));
    }

    @Test
    void wineer_판별하기() {
        assertThat(judgement.judgeWinner())
            .isEqualTo(winners);
    }
}
