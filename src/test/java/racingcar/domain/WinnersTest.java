package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void toStringTest() {
        assertThat(new Winners().toString()).isEqualTo("우승자 없음");

        List<Car> CarList = new ArrayList<>();
        CarList.add(new Car("A"));
        CarList.add(new Car("B"));
        assertThat(new Winners(CarList).toString()).isEqualTo("A, B 우승!");
    }

    @Test
    void contains() {
        List<Car> list = new ArrayList<>(10);
        list.add(new Car("A"));
        list.add(new Car("B"));
        list.add(new Car("C"));
        list.add(new Car("D"));
        list.add(new Car("E"));
        list.add(new Car("F"));
        list.add(new Car("G"));

        assertThat(new Winners(list).contains(new Car("E"))).isEqualTo(true);
        assertThat(new Winners(list).contains(new Car("I"))).isEqualTo(false);
    }

    @Test
    void equals() {
        List<Car> list = new ArrayList<>(10);
        list.add(new Car("A"));
        list.add(new Car("B"));
        list.add(new Car("C"));

        List<Car> compared = new ArrayList<>(10);
        compared.add(new Car("B"));
        compared.add(new Car("C"));
        compared.add(new Car("A"));

        assertThat(new Winners(list).equals(new Winners(compared))).isEqualTo(true);

        compared = new ArrayList<>(10);
        compared.add(new Car("A"));
        compared.add(new Car("B"));
        compared.add(new Car("D"));

        assertThat(new Winners(list).equals(new Winners(compared))).isEqualTo(false);
    }
}
