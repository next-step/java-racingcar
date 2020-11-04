package step3.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultControllerTest {

    private ResultController resultController;

    @BeforeEach
    void setUp(){
        resultController = new ResultController();
    }

    @DisplayName("위치 문자열 잘생성하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "2",
            "3",
            "4",
            "10",
    })
    public void test(Integer value){
        String s = resultController.makeLocationString(value);
        assertThat(s.length()).isEqualTo(value);
    }

    @DisplayName("레이싱 결과 생성 테스트 - 개행 테스")
    @ParameterizedTest
    @ValueSource(strings = {"10"})
    public void test2(Integer value) {
        List<Integer> list = new ArrayList<>();

        IntStream
                .range(0, value)
                .forEach(item -> {
                    list.add(20);
                });

        String racingResult = resultController.makeRacingResult(list);

        int lineCnt = 0;
        int fromIndex = -1;
        while ((fromIndex = racingResult.indexOf("\n", fromIndex + 1)) >= 0) {
            lineCnt++;
        }

        assertThat(value).isEqualTo(lineCnt);
    }

    @DisplayName("레이싱 결과 Null Point Exception test")
    @Test
    public void test3() {
        assertThatThrownBy(() -> {
            resultController.printRacingLog(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
