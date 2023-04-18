package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;

public class RaceResultTest {

    @DisplayName("경기결과 저장 테스트")
    @Test
    void name() {
        Car test1 = new Car("test1");
        test1.move();
        Car test2 = new Car("test2");
        List<Car> carList = new ArrayList<>();
        carList.add(test1);
        carList.add(test2);

        RaceRecord raceResult = new RaceRecord(carList);
        Map<String,Integer> result = raceResult.getResult();
        Assertions.assertThat(result.get("test1")).isEqualTo(2);
        Assertions.assertThat(result.get("test2")).isEqualTo(1);
    }
}
