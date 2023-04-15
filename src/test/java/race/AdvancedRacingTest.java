package race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.domain.Car;
import race.domain.Winner;

class AdvancedRacingTest {

    @DisplayName("입력받은 횟수 만큼 시도한다.")
    @Test
    void test7() throws Exception {
        String[] strings = {"name"};
        int trial = 3;

        Race race = new Race(strings, trial);

        assertThat(race.getTrial()).isEqualTo(trial);
    }

    @DisplayName("car가 움직일때 이름이 같이 출력된다.")
    @Test
    void test1() throws Exception {
        String name = "crong";
        Car crong = new Car(name);

        crong.move(4);

        assertThat(crong.getTracing()).contains(name);
    }

    @DisplayName("car가 움직인 거리를 알 수 있다.")
    @Test
    void test6() throws Exception {
        Car car = new Car("name");

        car.move(6);

        assertThat(car.getMovingDistance()).isEqualTo(1);
    }

    @DisplayName("우승자를 출력할 수 있다.")
    @Test
    void test9() throws Exception {
        List<Car> cars = getCarList();

        Winner winner = new Winner();
        List<String> strings = winner.get(cars);

        assertThat(strings).contains("choizz", "beck");
    }

    @DisplayName("이름이 5글자 이상이면 예외를 던진다.")
    @Test
    void test2() throws Exception {
        String name = "abcdefg";

        assertThatThrownBy(() -> {
            new Car(name);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("공백인 이름이 있을 경우 예외를 던진다.")
    @Test
    void test3() throws Exception {
        assertThatThrownBy(() -> {
            new Car("");
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 공백일 수 없습니다.");
    }

    @DisplayName("시행 횟수가 0이하인 경우 예외를 던진다.")
    @Test
    void test4() throws Exception {
        assertThatThrownBy(() -> {
            new Race(new String[]{"name"}, 0);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1 이상을 입력해 주세요");
    }

    @DisplayName("이름이 입력되지 않은 경우 예외를 던진다.")
    @Test
    void test5() throws Exception {
        assertThatThrownBy(() -> {
            new Race(new String[]{}, 1);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름을 입력해주세요.");
    }

    private List<Car> getCarList() {
        Car crong = new Car("crong", 3);
        Car choizz = new Car("choizz", 5);
        Car beck = new Car("beck", 5);

        List<Car> cars = new ArrayList<>();
        cars.add(crong);
        cars.add(choizz);
        cars.add(beck);

        return cars;
    }
}
