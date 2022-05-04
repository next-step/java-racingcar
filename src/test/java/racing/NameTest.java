package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.MovableStrategy;
import racing.domain.RandomNumMovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    MovableStrategy movableStrategy = new RandomNumMovableStrategy(()->3);

    @Test
    @DisplayName("이름 테스트")
    void 자동차_이름_테스트(){
        Car car = new Car(movableStrategy, "name");
        assertThat(car.getName()).isEqualTo("name");
    }


    @Test
    @DisplayName("이름 5글자 초과시 예외 테스트")
    void 자동차_이름길이_예외_테스트(){
        assertThatThrownBy(()->{
            Car car = new Car(movableStrategy, "123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
