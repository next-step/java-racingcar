package racingcar;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.Race;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RaceTest {
    @Test
    @Order(1)
    void 자동차_대수는_1대_이상이어야_한다() {
        assertThatThrownBy(() -> new Race().start("", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @Order(2)
    @ValueSource(ints = {3, 4, 5})
    void 주어진_횟수만큼_레이스가_진행된다(int tryCount) {
        assertThat(new Race().start("pobi", tryCount)).hasSize(tryCount);
    }

    @Test
    void 우승자는_한명_이상일수_있다() {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("win", 10));
        carsList.add(new Car("win2", 10));
        carsList.add(new Car("lose", 9));
        Cars cars = new Cars(carsList,new RaceCondition());

        assertThat(cars.getWinners()).isEqualTo("win,win2");
    }

}