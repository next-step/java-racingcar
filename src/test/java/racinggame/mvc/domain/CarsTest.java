package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("참가 자동차 목록을 입력 순서대로 반환한다.")
    void 자동차_목록을_반환한다() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Cars sut = new Cars(List.of(pobi, crong));

        assertThat(sut.getCars()).containsExactly(pobi, crong);
    }

    @Test
    @DisplayName("쉼표로 이름을 구분하고 입력한 이름마다 자동차를 생성한다.")
    void 이름_문자열로_자동차_목록을_만든다() {
        Cars sut = new Cars(" pobi, crong ,honux ");

        assertThat(sut.getCars())
            .extracting(Car::getName)
            .containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("가장 멀리 간 자동차를 모두 반환한다.")
    void 가장_멀리_간_자동차_목록을_반환한다() {
        Car pobi = new Car("pobi", 2);
        Car crong = new Car("crong", 4);
        Car honux = new Car("honux", 4);
        Cars sut = new Cars(List.of(pobi, crong, honux));

        assertThat(sut.farthestCars()).containsExactly(crong, honux);
    }

    @Test
    @DisplayName("자동차마다 숫자를 하나씩 받아 이동을 시도한다.")
    void 자동차마다_이동을_시도한다() {
        Cars sut = new Cars("pobi,crong,honux");
        Iterator<Integer> numbers = List.of(4, 3, 5).iterator();

        sut.move(numbers::next);

        assertThat(sut.getCars())
            .extracting(Car::getPosition)
            .containsExactly(1, 0, 1);
    }
}
