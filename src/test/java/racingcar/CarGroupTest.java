package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupTest {
    //given
    String carNames = "poby,crong,honux";
    CarGroup carGroup = new CarGroup(carNames);

    @Test
    @DisplayName("(0)생성자 테스트")
    public void carGroup() {
        //given, when
        String carNamesForConstructorTest = ",,";

        //then
        Assertions.assertThatThrownBy(() -> {
            new CarGroup(carNamesForConstructorTest);
        }).isInstanceOf(IllegalArgumentException.class);
    }

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
    @DisplayName("(3)자동차 배열 내의 자동차 이름 전달")
    public void name() {
        //when, then
        Assertions.assertThat(carGroup.carName(0)).isEqualTo("poby");
    }
}
