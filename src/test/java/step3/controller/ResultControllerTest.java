package step3.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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

}
