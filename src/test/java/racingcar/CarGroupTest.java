package racingcar;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupTest {
    //given
    String carNames = "poby,crong,honux";
    CarGroup carGroup = new CarGroup(carNames);

    @Test
    @DisplayName("(1)자동차 배열의 길이 전달")
    public void carGroupSize() {
        //when, then
        Assertions.assertThat(carGroup.carGroupSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("(2)자동차 배열 내의 자동차 위치 전달")
    public void position() {
        //when, then
        for (int i = 0; i < carGroup.carGroupSize(); i++) {
            Assertions.assertThat(carGroup.position(i)).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("(3)자동차 배열 내의 모든 자동차 위치를 업데이트")
    public void updateCarArrayPosition() {
        // when
        carGroup.updateCarArrayPosition();

        //then (Car Class's Random seed: 54321)
        int[] actual = {1, 0, 0};
        for (int i = 0; i < carGroup.carGroupSize(); i++) {
            Assertions.assertThat(carGroup.position(i)).isEqualTo(actual[i]);
        }
    }

    @Test
    @DisplayName("(4) 자동차 배열 내의 자동차 이름 전달")
    public void name(){
        //when, then
        Assertions.assertThat(carGroup.carName(0)).isEqualTo("poby");
    }

    @Test
    @DisplayName("(5) 우승자 선정")
    public void winner(){
        //given
        String carNamesForWinnerTest = "poby,crong,honux";
        String[] carNamesForWinnerTestArray = carNamesForWinnerTest.split(",");
        CarGroup carGroupForWinnerTest = new CarGroup(carNamesForWinnerTest);

        //when, then
        for (int i = 0; i < CarGroupForWinnerTest.carGroupSize(); i++){
            Assertions.assertThat(carGroupForWinnerTest.winner()[i]).isEqualTo(carNamesForWinnerTestArray[i]);
        }
    }
}
