package carracing;

import carracing.domain.CarCompany;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCompanyTest {
    @Test
    @DisplayName("자동차 객체 이름 갯수만큼 생성되는지 테스트")
    void createCarObject() {
        String carNames = "kim,woo,hun";
        assertThat(CarCompany.createCar(carNames).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차이름 split 테스트")
    void splitCarName() {
        String carNames = "kim,woo,hun";
        String [] arrCarNames = CarCompany.splitCarName(carNames);
        assertThat(arrCarNames).containsExactly("kim","woo","hun");
    }

}
