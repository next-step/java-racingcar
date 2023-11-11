package study.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("우승자 리스트는 위치가 큰 자동차의 이름이 출력된다.")
    void pick_winners() {
        Winners winners = new Winners();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Position(4), new Name("pobi")));
        cars.add(new Car(new Position(4), new Name("hyun")));
        cars.add(new Car(new Position(3), new Name("park")));

        List<String> names = winners.pickWinners(cars);

        assertThat(names).containsExactly("pobi", "hyun");

    }
}