package race.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RefereeTest {

    @Test
    void name() {
        Car hyungjunn = new Car(1, "임형준");
        Car seunghun = new Car(500, "최승훈");
        Car pobi = new Car(0, "포비");

        List<Car> cars = Arrays.asList(hyungjunn, seunghun, pobi);

        Referee referee = new Referee(cars);

        Assertions.assertThat(referee.findWinner()).contains(seunghun);
    }

}
