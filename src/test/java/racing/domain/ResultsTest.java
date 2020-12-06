package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Results;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsTest {
    @DisplayName("N회 결과 저장")
    @Test
    void getWinners() throws Exception {
        //given
        CarName a = new CarName("a");
        CarName b = new CarName("b");
        Cars step1 = new Cars("a,b", new FixedPowerGenerator());
        Cars step2 = new Cars(Arrays.asList(new Car(a, 1), new Car(b, 2)), new FixedPowerGenerator());

        Results results = new Results(Arrays.asList(new Result(step1), new Result(step2)));

        //when
        List<Car> winners = results.getFinalWinners();

        //then
        assertEquals(winners.size(), 1);
    }
}
