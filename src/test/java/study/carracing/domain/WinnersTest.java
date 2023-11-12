package study.carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnersTest {

    private Winners winners = new Winners();
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car(new Position(4), new Name("pobi")));
        cars.add(new Car(new Position(4), new Name("hyun")));
        cars.add(new Car(new Position(3), new Name("park")));
    }

    @Test
    @DisplayName("우승자 리스트는 위치가 큰 자동차의 이름이 출력된다.")
    void pick_winners() {
        List<String> names = winners.pickWinners(cars);

        assertThat(names).containsExactly("pobi", "hyun");
    }

    @Test
    @DisplayName("우승자 리스트의 값을 변경하면 UnsupportedOperationException예외가 발생한다.")
    void not_allow_to_modify_winners() {
        List<String> names = winners.pickWinners(cars);

        assertThatThrownBy(() -> names.add("new winner"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
