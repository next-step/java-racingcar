package race.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RefereeTest {

    @DisplayName("레프리가 우승자를 찾아 가장 멀리 간 자동차를 반환하는 것을 테스트한다")
    @Test
    void findWinnerTest() {
        Car hyungjunn = new Car(1, "임형준");
        Car seunghun = new Car(500, "최승훈");
        Car pobi = new Car(0, "포비");

        List<Car> cars = List.of(hyungjunn, seunghun, pobi);

        Referee referee = new Referee(cars);

        Assertions.assertThat(referee.findWinner()).contains(seunghun);
    }

}
