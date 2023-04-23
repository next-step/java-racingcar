package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnerTest {

    private List<Car> cars = new ArrayList<>();
    Winner winner = new Winner();

    @BeforeEach
    void setCars(){
        cars.add(new Car("car1", 1));
        cars.add(new Car("car2", 5));
        cars.add(new Car("car3", 5));
    }

    @ParameterizedTest(name = "winners contains {0}")
    @ValueSource(strings = {"car2", "car3"})
    void 우승자_이름(String name) {
        List<Car> winners = winner.addWinner(cars);
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getName());
        }
        assertThat(names.contains(names));
    }

    @Test
    void 우승자가_아닌_이름() {
        List<Car> winners = winner.addWinner(cars);
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getName());
        }
        assertThat(names.contains("user1"));
    }

    @Test
    void 우승자_수() {
        assertThat(winner.addWinner(cars)).hasSize(2);
    }

    @Test
    void 최대_이동수() {
        winner.addWinner(cars);
        assertThat(winner.getMax()).isEqualTo(5);
    }

}
