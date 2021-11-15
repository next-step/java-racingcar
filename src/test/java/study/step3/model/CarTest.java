package study.step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @DisplayName("차량 위치값 동일 확인")
    @ParameterizedTest(name="{displayName} | 시도 점수: {0}")
    @ValueSource(ints = {1, 2, 3})
    public void 차량_이동_여부_숫자가_동일(int location){
        Car car = new Car(location);

        assertThat(car.getCarLocation()).isEqualTo(location);
    }

}
