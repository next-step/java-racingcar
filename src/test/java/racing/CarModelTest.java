package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarModelTest {

    @Test
    @DisplayName("CarModel class에 setter에 값을 주입시키면 getter로 값을 받을수 있다.")
    public void SetterInDataAndGetterOutData_check() {
        CarModel carModel1 = new CarModel(1);
        carModel1.setRaceDistance("--");

        CarModel carModel2 = new CarModel(2);
        carModel2.setRaceDistance("---");

        assertThat(carModel1.getRaceDistance()).isEqualTo("--");
        assertThat(carModel2.getRaceDistance()).isEqualTo("---");
    }
}