package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("생성된 자동차의 개수")
    void carCount(){
        Cars cars = Cars.makeCars(5);
        assertThat(cars.getCars()).hasSize(5);
    }

    @Test
    @DisplayName("생성된 자동차가 없을 시 에러발생")
    void carsNullChk(){
        assertThatThrownBy(() -> Cars.makeCars(0))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("자동차를 생성해주세요");
    }

}
