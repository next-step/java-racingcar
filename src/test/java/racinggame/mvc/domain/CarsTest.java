package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("가장 멀리 간 자동차를 모두 반환한다.")
    void 가장_멀리_간_자동차_목록을_반환한다() {
        Car pobi = new Car("pobi", 2);
        Car crong = new Car("crong", 4);
        Car honux = new Car("honux", 4);
        Cars sut = new Cars(List.of(pobi, crong, honux));

        assertThat(sut.farthestCars()).containsExactly(crong, honux);
    }
}
