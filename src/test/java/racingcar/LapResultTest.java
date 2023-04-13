package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LapResultTest {

    @Test
    void 랩_결과() {
        String name = "참가자1";
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(name));
        assertThat(new LapResult(carList).lapResultString()).matches("(" + name + " : -\n)\n");
    }

}
