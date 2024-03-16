package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarGroupTest {
    CarGroup carGroup = new CarGroup();

    @Test
    @DisplayName("(1)자동차 배열에 입력받은 갯수만큼 자동차 생성")
    public void resizeCarArray() {
        carGroup.resizeCarArray(3);
    }

    @Test
    @DisplayName("(2)자동차 배열의 길이 전달")
    public void carGroupLength() {
        Assertions.assertThat(carGroup.carGroupLength()).isEqualTo(3);
    }

    @Test
    @DisplayName("(3)자동차 배열 내의 자동차 위치 전달")
    public void position() {
        for (int i = 0; i < carGroup.carGroupLength(); i++) {
            Assertions.assertThat(carGroup.carGroup[i].position()).isEqualTo(1);
        }
    }

    @ParameterizedTest
    @DisplayName("(4)자동차 배열 내의 모든 자동차 위치를 업데이트")
    @ValueSource(ints = {1, 0, 0})
    public void updateCarArrayPosition(int actual) {
        carGroup.updateCarArrayPosition();
        for (int i = 0; i < carGroup.carGroupLength(); i++) {
            Assertions.assertThat(carGroup.carGroup[i].position()).isEqualTo(actual);
        }
    }
}
