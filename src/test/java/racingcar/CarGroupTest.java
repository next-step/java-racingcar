package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarGroupTest {
    //given
    List<String> carNames = new ArrayList<>(Arrays.asList("poby", "grape", "hello"));
    CarGroup carGroup = new CarGroup(carNames);

    @ParameterizedTest
    @DisplayName("(0)생성자 테스트")
    @NullAndEmptySource
    @ValueSource(strings = {"longname"})
    public void carGroup(String name) {
        //given, when
        List<String> carNamesForConstructorTest = new ArrayList<>();
        carNamesForConstructorTest.add(name);

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
