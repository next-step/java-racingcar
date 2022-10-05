package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("앞으로 한칸 전지")
    @Test
    void 전진하는_경우_테스트() {
        Car car = new Car("pobi", 0);
        car.move(() -> 1);

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("제자리 걸음")
    @Test
    void 제자리에_있는_테스트() {
        Car car = new Car("pobi", 0);
        car.move(() -> 0);

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("생성자 테스트")
    @Test
    void 생성자_테스트() {
        Car car = new Car("pobi",0 );

        assertThat(car).isEqualTo(new Car("pobi", 0));
    }

    @DisplayName("이름이 5자 이상이면 에러를 반환")
    @Test
    void 이름이_5자_이상이면_에러_반환() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("123456", 1);
        }).withMessage("이름은 5자를 초과할 수 없습니다.");
    }

}