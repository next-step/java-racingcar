package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;

class RaceTest {

    @DisplayName("난수가 5일때 배열의 숫자가 증가하는지 확인한다")
    @Test
    public void checkWhenRandomNumberIsFive() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("audi"));
        cars.add(new Car("benz"));
        cars.add(new Car("bmw"));
        Race race = new Race(cars);
        race.compareWithFour(cars.get(1), 5);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
    }

    @DisplayName("난수가 4일때 배열의 숫자가 증가하는지 확인한다")
    @Test
    public void checkWhenRandomNumberIsFour() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("audi"));
        cars.add(new Car("benz"));
        cars.add(new Car("bmw"));
        Race race = new Race(cars);
        race.compareWithFour(cars.get(1), 4);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
    }

    @DisplayName("난수가 3일때 배열의 숫자가 증가하는지 확인한다")
    @Test
    public void checkWhenRandomNumberIsThree() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("audi"));
        cars.add(new Car("benz"));
        cars.add(new Car("bmw"));
        Race race = new Race(cars);
        race.compareWithFour(cars.get(1), 3);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
    }

    @Test
    public void getMaxScore() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("one"));
        cars.add(new Car("two"));
        cars.add(new Car("three"));


    }
}