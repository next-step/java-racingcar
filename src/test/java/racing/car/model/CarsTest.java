package racing.car.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.domain.Car;
import racing.car.random.Random;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("Cars 리스트 최대값 반환")
    void 최대값_반환_테스트() {
        Cars cars = new Cars(List.of(new Car("dong", 5), new Car("pling", 4), new Car("iiwq", 3)));

        int max = cars.getMaxPosition();

        assertThat(max).isEqualTo(5);
    }

    @Test
    @DisplayName("Cars 클래스 addCars 메서드 초기값 선언 테스트")
    void 초기값_선언_테스트() {
        List<Car> initialCars = new ArrayList<>();
        Cars cars = new Cars(initialCars);

        cars.addCars(new String[]{"phobi", "covi", "dong"});

        assertThat(initialCars).isEqualTo(List.of(new Car("phobi",0), new Car("covi",0), new Car("dong",0)));
    }

    @Test
    @DisplayName("Cars 클래스 move 메서드 테스트")
    void move_메서드_테스트(){
        List<Car> initialCars = List.of(new Car("phobi", 0), new Car("doung", 0));
        Cars cars = new Cars(initialCars);
        cars.move(()-> 4);

        assertThat(initialCars).isEqualTo(List.of(new Car("phobi", 1), new Car("doung",1)));
    }

    @Test
    @DisplayName("max 최대 값5와 똑같은 우승자 찾기 메서드 테스트")
    void find_winner_우승자_찾기(){
        List<Car> initialCars = List.of(new Car("phobi", 5), new Car("doung", 3), new Car("bbj", 5), new Car("kim", 4));

        int maxPosition = 5;
        Cars cars = new Cars(initialCars);
        List<Car> winner = cars.findWinner(maxPosition);
        assertThat(winner).contains(new Car("phobi", maxPosition), new Car("bbj", maxPosition));
        assertThat(winner).hasSize(2);
    }

}