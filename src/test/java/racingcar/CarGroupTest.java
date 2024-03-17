package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupTest {

    @Test
    @DisplayName("(1)자동차 배열의 길이 전달")
    public void carGroupLength() {
        //given
        int actualCarGroupLength = 3;
        CarGroup carGroup = new CarGroup(actualCarGroupLength);

        //when
        int carGroupLength = carGroup.carGroupLength();

        //then
        Assertions.assertThat(carGroupLength).isEqualTo(actualCarGroupLength);
    }

    @Test
    @DisplayName("(2)자동차 배열 내의 자동차 위치 전달")
    public void position() {
        //given
        int carGroupLength = 3;
        CarGroup carGroup = new CarGroup(carGroupLength);

        //when, then
        for (int i = 0; i < carGroup.carGroupLength(); i++) {
            Assertions.assertThat(carGroup.position(i)).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("(3)자동차 배열 내의 모든 자동차 위치를 업데이트")
    public void updateCarArrayPosition() {
        // given
        int carGroupLength = 3;
        CarGroup carGroup = new CarGroup(carGroupLength);

        // when
        carGroup.updateCarArrayPosition();

        //then (Car Class's Random seed: 54321)
        int[] actual = {1, 0, 0};
        for (int i = 0; i < carGroup.carGroupLength(); i++) {
            Assertions.assertThat(carGroup.position(i)).isEqualTo(actual[i]);
        }
    }
}
