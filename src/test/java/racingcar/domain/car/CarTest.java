package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.random.MoveGen;
import racingcar.domain.random.NoMoveGen;

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

    @DisplayName("go() 메서드 호출 후 차량의 위치는 그 횟수만큼 증가된다.")
    @Test
    public void go_메서드_테스트() {
        //given
        Car car1 = Car.from("jason");

        //when
        car1.go(new MoveGen());
        car1.go(new MoveGen());

        //then
        assertThat(car1.getPosition()).isEqualTo(2);
    }

    @Test
    public void 이름이_5자_이하인_차량은_Exception발생안함() {
        //given
        String name = "jason";

        //when

        //then
        assertThatCode(() -> Car.from(name)).doesNotThrowAnyException();
    }

    @Test
    public void 이름이_5자를_초과한_차량은_Exception발생() {
        //given
        String name = "jason1";

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car.from(name);
        });
    }

    @Test
    public void 전진조건_만족시_차량의_위치가_일치하는지() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");
        cars.add(car1);
        cars.add(car2);

        //when
        cars.stream().forEach(car -> car.go(new MoveGen()));

        //then
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
    }

    @Test
    public void 전진조건_불만족시_차량의_위치가_변하지_않는지() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");
        cars.add(car1);
        cars.add(car2);

        //when
        cars.stream().forEach(car -> car.go(new NoMoveGen()));

        //then
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
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

        Collections.sort(cars, (o1, o2) -> o2.position - o1.position);

        //then
        assertThat(cars.get(0).getName()).isEqualTo("jason");
        assertThat(cars.get(1).getName()).isEqualTo("pobi");
        assertThat(cars.get(2).getName()).isEqualTo("sung");
    }
}