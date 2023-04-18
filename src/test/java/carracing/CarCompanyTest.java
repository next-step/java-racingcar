package carracing;

import carracing.domain.CarCompany;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarCompanyTest {
    @Test
    @DisplayName("자동차 객체 이름 갯수만큼 생성되는지 테스트")
    void createCarObject() {
        String carNames = "kim,woo,hun";
        CarCompany carCompany = new CarCompany();
        assertThat(carCompany.createCar(carNames).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차이름 split 테스트")
    void splitCarName() {
        String carNames = "kim,woo,hun";
        CarCompany carCompany = new CarCompany();
        String [] arrCarNames = carCompany.splitCarName(carNames);
        assertThat(arrCarNames).containsExactly("kim","woo","hun");
    }

    @Test
    @DisplayName("자동차이름이 5글자가 초과할경우 익셉션 테스트")
    void checkNameNumberOverFive() {
        CarCompany carCompany = new CarCompany();
        assertThatThrownBy(() -> carCompany.checkNameNumber("kimwoo"))
                .isInstanceOf(RuntimeException.class);
    }
}
