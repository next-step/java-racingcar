package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("차량 인스턴스 생성 후 이름은 정확하게 저장된다")
    @Test
    public void getName_메서드_테스트() {
        //given
        Car car = Car.from("jason");

        //when

        //then
        assertThat(car.getName()).isEqualTo("jason");
    }

    @Test
    public void go_메서드의_인자가_5이상이면_차량의_위치는_그_횟수만큼_증가한다() {
        //given
        Car prevCar = Car.from("jason");

        //when
        Car nextCar1 = prevCar.go(5);
        Car nextCar2 = nextCar1.go(5);

        //then
        assertThat(prevCar.getPosition()).isEqualTo(0);
        assertThat(nextCar1.getPosition()).isEqualTo(1);
        assertThat(nextCar2.getPosition()).isEqualTo(2);
    }

    @Test
    public void go_메서드의_인자가_5미만이면_차량의_위치는_증가하지_않는다() {
        //given
        Car prevCar = Car.from("jason");

        //when
        Car nextCar1 = prevCar.go(4);
        Car nextCar2 = nextCar1.go(4);

        //then
        assertThat(prevCar.getPosition()).isEqualTo(0);
        assertThat(nextCar1.getPosition()).isEqualTo(0);
        assertThat(nextCar2.getPosition()).isEqualTo(0);
    }

    @DisplayName("List<Car>를 정렬하면 위치의 내림차순으로 정렬된다.")
    @Test
    public void 내림차순_정렬_테스트() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.of("jason", 3);
        Car car2 = Car.of("pobi", 2);
        Car car3 = Car.of("sung",1);

        //when
        cars.add(car3);
        cars.add(car1);
        cars.add(car2);

        Collections.sort(cars, (o1, o2) -> o2.getPosition() - o1.getPosition());

        //then
        assertThat(cars.get(0).getName()).isEqualTo("jason");
        assertThat(cars.get(1).getName()).isEqualTo("pobi");
        assertThat(cars.get(2).getName()).isEqualTo("sung");
    }
}