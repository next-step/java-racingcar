package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarControllerTest {

    @Test
    @DisplayName("CarList 초기화 성공 테스트")
    void initCarListTest() {
        CarController controller = new CarController();
        CarList carList = controller.initCarList(3);

        assertThat(carList.getCarList().size()).isEqualTo(3);
    }

}
