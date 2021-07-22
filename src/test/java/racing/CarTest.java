package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차는 랜덤함수가 4이상이면 전진하고 4미만이면 정지한다.")
    public void SetterInDataAndGetterOutData_check() {
        Car car1 = new Car(1);
        int resultRacing1 = car1.carRacingAct(3);

        assertThat(resultRacing1).isEqualTo(0);

        int resultRacing2 = car1.carRacingAct(6);

        assertThat(resultRacing2).isEqualTo(1);

    }
}