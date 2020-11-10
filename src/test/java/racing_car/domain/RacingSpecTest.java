package racing_car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingSpecTest {

    @DisplayName("레이싱 스펙 유효성 검사 예외 발생 테스트 - userName List 가 Null 일때")
    @Test
    public void test1() {
        List<String> userNameList = null;

        assertThatThrownBy(() -> {
            RacingSpec racingSpec = new RacingSpec(userNameList, 10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레이싱 스펙 유효성 검사 예외 발생 테스트 - userName List 가 empty 상태일때")
    @Test
    public void test2() {
        List<String> userNameList = new ArrayList<>();

        assertThatThrownBy(() -> {
            RacingSpec racingSpec = new RacingSpec(userNameList, 10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레이싱 스펙 유효성 검사 예외 발생 테스트 - lab 이 0 보다 같거나 자을때 ")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void test3(Integer lab) {
        List<String> userNameList = new ArrayList<>();
        userNameList.add("name");
        assertThatThrownBy(() -> {
            RacingSpec racingSpec = new RacingSpec(userNameList, lab);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
