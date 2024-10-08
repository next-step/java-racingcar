package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.car.Car;
import racing.car.car.Cars;
import racing.car.random.Random;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("Cars 리스트 최대값 반환")
    void 최대값_반환_테스트() {
        Cars cars = new Cars(List.of(new Car("dong", 5), new Car("pling", 4), new Car("iiwq", 3)));

        int max = cars.max();

        assertThat(max).isEqualTo(5);
    }

    @Test
    @DisplayName("Cars 클래스 initialize 메서드 초기값 선언 테스트")
    void 초기값_선언_테스트() {
        List<Car> initialCars = new ArrayList<>();
        Cars cars = new Cars(initialCars);

        cars.initialize(new String[]{"phobi", "covi", "dong"});

        assertThat(initialCars).isEqualTo(List.of(new Car("phobi",0), new Car("covi",0), new Car("dong",0)));
    }

    @Test
    @DisplayName("Cars 클래스 move 메서드 테스트")
    void move_메서드_테스트(){
        List<Car> initialCars = List.of(new Car("phobi", 0), new Car("doung", 0));
        Cars cars = new Cars(initialCars);
        cars.move(new Random() {
            @Override
            public int random() {
                return 4;
            }
        });

        assertThat(initialCars).isEqualTo(List.of(new Car("phobi", 1), new Car("doung",1)));
    }

    @Test
    @DisplayName("max 값과 똑같은 우승자 찾기 메서드 테스트")
    void find_winner_우승자_찾기(){
        List<Car> initialCars = List.of(new Car("phobi", 5), new Car("doung", 3), new Car("bbj", 5), new Car("kim", 4));

        Cars cars = new Cars(initialCars);
        List<Car> winner = cars.findWinner(5);
        assertThat(winner).contains(new Car("phobi", 5), new Car("bbj", 5));
        assertThat(winner).hasSize(2);
    }

}