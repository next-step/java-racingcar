package carracing;

import carracing.domain.CarCompany;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCompanyTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void createCarObject() {
        int numberOfCar = 4;
        CarCompany carCompany = new CarCompany();
        assertThat(carCompany.createCar(numberOfCar).size()).isEqualTo(4);
    }
}
