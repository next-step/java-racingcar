package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("생성자 테스트")
    @Test
    void 생성자_테스트() {
        Car car = new Car("pobi",0 );

        assertThat(car).isEqualTo(new Car( "pobi", 0));
    }

}