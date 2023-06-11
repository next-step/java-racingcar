package edu.nextstep.camp.racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingInfoTest {

    private static final int COMMON_MOVING_VAL = 5;

    @ParameterizedTest
    @ValueSource(strings = {"RIDER123,RIDER234", "  ,   "})
    void 운전자_이름_길이_및_공백_검증(String names){
        assertThatThrownBy(()-> RacingInfo.of("RIDER123,RIDER234", COMMON_MOVING_VAL))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백일 수 없으며, 5자 이하로 작성 하세요");
    }

    @Test
    void 운전자_이름_중복_검증(){
        assertThatThrownBy(()-> RacingInfo.of("RIDER,RIDER", COMMON_MOVING_VAL))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("carCountValidParams")
    void 자동차_대수_검증(String cars){
        assertThatThrownBy(()-> RacingInfo.of(cars, COMMON_MOVING_VAL))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 수는 2~20대로 설정 하세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 201})
    void 자동차_시도_횟수_검증(int movingCount){
        assertThatThrownBy(()-> RacingInfo.of("C1,C2", movingCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 시도 횟수는 5~200회로 설정 하세요.");
    }

    private static Stream<String> carCountValidParams(){
        return Stream.of("RIDER", carsString(21));
    }

    private static String carsString(int carsCount){
        if (carsCount <= 0){
            throw new IllegalArgumentException("1 이상 입력 하세요");
        }

        List<String> charSequences = new ArrayList<>();

        for (int i = 0; i < carsCount; i++) {
            charSequences.add("C"+i);
        }

        return String.join(",", charSequences);
    }
}
