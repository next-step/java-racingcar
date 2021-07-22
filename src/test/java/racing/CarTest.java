package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("Car class에 전진/정지 값을 true, false로 넣으면 전진 및 정지를 한다.")
    public void SetterInDataAndGetterOutData_check() {
        Car carModel1 = new Car(1);
        carModel1.carRacingAct(true);
        String model1Distance = carModel1.carRacingAct(true);

        Car carModel2 = new Car(2);
        carModel2.carRacingAct(true);
        String model2Distance = carModel2.carRacingAct(false);

        assertThat(model1Distance).isEqualTo("--");
        assertThat(model2Distance).isEqualTo("-");
    }
}