package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.car.Car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

 class Step5CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void car_make_test() {
        
        String name = "홍길동";

        
        Car car = Car.defaultOf(name);

        
        assertThat(car).extracting("name").isNotNull();

    }
    
    @Test
    @DisplayName("기본 거리 1 테스트")
    void default_distance_one() throws Exception {
        String name = "홍길동";
        Car car = Car.defaultOf(name);

        boolean result = car.sameDistance(1);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("자동차 이름 5자 제한 기능 테스트")
    void name_limit_length() {
        
        String name = "이름이5자이상";

        
        assertThrowsExactly(IllegalArgumentException.class, () -> Car.defaultOf(name));
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    public void car_move_test() {
        String name = "홍길동";
        Car car = Car.defaultOf(name);

        Car movedCar = car.move(true);

        Assertions.assertThat(movedCar.sameDistance(2)).isTrue();
    }

    @Test
    @DisplayName("자동차 거리 비교")
    public void compareCarDistance() throws Exception {
        // given
        Car loser = Car.defaultOf("포비",3);
        Car winner = Car.defaultOf("아톰",4);

        // when
        boolean result = winner.fartherThan(loser);

        // then
        Assertions.assertThat(result).isTrue();
    }


}
