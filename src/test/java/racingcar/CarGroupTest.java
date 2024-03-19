package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class

CarGroupTest {
    //given
    String[] carNames = {"poby", "crong", "honux"};
    CarGroup carGroup = new CarGroup(carNames);

    @Test
    @DisplayName("(1)자동차 배열의 길이 전달")
    public void carGroupSize() {
        //when, then
        Assertions.assertThat(carGroup.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("(2)자동차 배열 내의 자동차 위치 전달")
    public void position() {
        //when, then
        for (int i = 0; i < carGroup.size(); i++) {
            Assertions.assertThat(carGroup.position(i)).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("(3)자동차 배열 내의 모든 자동차 위치를 업데이트")
    public void updateCarArrayPosition() {
        // when
        carGroup.updateCarArrayPosition(5);

        // then
        for (int i = 0; i < carGroup.size(); i++) {
            Assertions.assertThat(carGroup.position(i)).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("(4) 자동차 배열 내의 자동차 이름 전달")
    public void name(){
        //when, then
        Assertions.assertThat(carGroup.carName(0)).isEqualTo("poby");
    }


}
