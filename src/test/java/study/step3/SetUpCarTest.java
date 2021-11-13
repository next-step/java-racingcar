package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SetUpCarTest {

    // 입력 문자 체크 validateParameter
    @DisplayName("입력값이 null인 경우 IllegalArgumentException 처리")
    @Test
    public void 입력값이_null(){
        assertThatThrownBy(() -> {
            SetUpCar.validateParameter(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 빈 공백 문자인 경우 IllegalArgumentException 처리")
    @Test
    public void 입력값이_빈_공백_문자(){
        assertThatThrownBy(() -> {
            SetUpCar.validateParameter("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 문자인 경우 IllegalArgumentException 처리")
    @ParameterizedTest(name="{displayName} | 입력값: {0}")
    @ValueSource(strings = {"one", "영", "구"})
    public void 입력값이_문자(String param){
        assertThatThrownBy(() -> {
            SetUpCar.validateParameter(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 1보다 작은 수인 경우 IllegalArgumentException 처리")
    @ParameterizedTest(name="{displayName} | 입력값: {0}")
    @ValueSource(strings = {"0", "-1"})
    public void 입력값이_1보다_작은_수(String param){
        assertThatThrownBy(() -> {
            SetUpCar.validateParameter(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // 개수 체크  generateCarList
    @DisplayName("자동차 리스트 개수 조회")
    @ParameterizedTest(name="{displayName} | 리스트 개수: {0}")
    @ValueSource(strings = {"2", "5"})
    void 자동차_리스트_개수_조회(int param) {
        assertThat(SetUpCar.generateCarList(param).size()).isEqualTo(param);
    }
}