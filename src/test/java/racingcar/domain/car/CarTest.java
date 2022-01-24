package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Participants;
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
        Assertions.assertThat(car.getName()).isEqualTo("jason");
    }

    @DisplayName("go() 메서드 호출 후 차량의 위치는 그 횟수만큼 증가된다.")
    @Test
    public void go_메서드_테스트() {
        //given
        Car car1 = Car.from("jason");

        //when
        car1.go();
        car1.go();

        //then
        Assertions.assertThat(car1.getPosition()).isEqualTo(2);
    }

    @DisplayName("compareTo() 테스트")
    @Test
    public void 위치비교시_우선순위_테스트() {
        //given
        Car car1 = Car.of("jason", 3);
        Car car2 = Car.of("pobi", 2);

        //when

        //then
        Assertions.assertThat(car1.compareTo(car2)).isLessThan(0);
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

        Collections.sort(cars);

        //then
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("jason");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("sung");
    }

    @DisplayName("두 차량이 호출한 go() 메서드의 횟수가 같다면 저장된 위치도 같다.")
    @Test
    public void 위치_비교_참_테스트() {
        //given
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");
        Move move = Move.get();
        Participants participants = Participants.getInstance(Arrays.asList(car1, car2));

        //when
        participants.moveCarIfPositionChanged(0, move.isSatisfiedMoveCondition(new MoveGen()));
        participants.moveCarIfPositionChanged(1, move.isSatisfiedMoveCondition(new MoveGen()));

        //then
        Assertions.assertThat(car1.getPosition()).isEqualTo(car2.getPosition());
    }

    @DisplayName("두 차량이 호출한 go() 메서드의 횟수가 다르다면 저장된 위치도 다르다.")
    @Test
    public void 위치_비교_거짓_테스트() {
        //given
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");
        Move move = Move.get();
        Participants participants = Participants.getInstance(Arrays.asList(car1, car2));

        //when
        participants.moveCarIfPositionChanged(0, move.isSatisfiedMoveCondition(new MoveGen()));
        participants.moveCarIfPositionChanged(1, move.isSatisfiedMoveCondition(new NoMoveGen()));

        //then
        Assertions.assertThat(car1.getPosition()).isNotEqualTo(car2.getPosition());
    }
}