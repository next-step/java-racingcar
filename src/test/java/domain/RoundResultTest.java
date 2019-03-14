package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundResultTest {
    @Test
    public void check_round_result_created() {
        List<CarResult> list = new ArrayList<>();
        list.add(new CarResult(new Car()));
        list.add(new CarResult(new Car()));
        list.add(new CarResult(new Car()));

        RoundResult roundResult = new RoundResult(1, list);
        assertThat(roundResult.getRoundNumber()).isEqualTo(1);
        assertThat(roundResult.getCarResults().size()).isEqualTo(3);
    }
}
