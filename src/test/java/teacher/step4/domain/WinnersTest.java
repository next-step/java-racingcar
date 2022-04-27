package teacher.step4.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    // 객체의 상태가
    // input 과 output을 먼저 확인
    @Test
    void findWinners() {
        List<Car> cars = new ArrayList<>();

        // 테스트하기 위에 번거로운 코드 작성이 있다.
//        Car pobi = new Car("pobi");
//        pobi.move(4);
//        pobi.move(4);
//        cars.add(pobi);
//
//        Car jason = new Car("jason");
//        jason.move(4);
//        cars.add(jason);
//
//        cars.add(new Car("cu"));


        // 생성자를 통해서 하면 간단하게 코드 작성이 가능하다.
        // 도메인 객체를 생성할 때는 생성자와 final 키워드를 사용해서 생성하는 것이 좋은 방향이다.
        cars.add(new Car("pobi", 3));
        cars.add(new Car("jason", 2));
        cars.add(new Car("cu", 1));

        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners).contains(new Car("pobi", 3));
    }
}
