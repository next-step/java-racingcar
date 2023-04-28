package carracing;

import carracing.domain.CarCompany;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCompanyTest {
    @Test
    @DisplayName("콤마로 나눈 자동차 이름 갯수만큼 자동차 객체가 생성되는지 테스트")
    void createCarObjectTest() {
        String carNames = "kim,woo,hun";
        assertThat(CarCompany.createCar(carNames)).hasSize(3);
    }

}
