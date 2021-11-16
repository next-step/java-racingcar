package study.step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingSettingTest {

    @DisplayName("주행 차량수가 1보다 작은 경우 IllegalArgumentException 처리")
    @ParameterizedTest(name="{displayName} | 입력값: {0}")
    @ValueSource(ints = {0, -1})
    public void 주행_차량수가_1보다_작은_경우(int param){
        assertThatThrownBy(() -> {
            RacingSetting racingSetting = new RacingSetting(param, param);
            Method method = racingSetting.getClass().getDeclaredMethod("validateCarCount", int.class);
            method.setAccessible(true);
            method.invoke(racingSetting, param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주행 차량수가 1보다 큰 경우")
    @ParameterizedTest(name="{displayName} | 입력값: {0}")
    @ValueSource(ints = {2, 3, 4})
    public void 주행_차량수가_1보다_큰_경우(int param) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        RacingSetting racingSetting = new RacingSetting(param, param);
        Method method = racingSetting.getClass().getDeclaredMethod("validateCarCount", int.class);
        method.setAccessible(true);
        method.invoke(racingSetting, param);
    }

    @DisplayName("시도 횟수가 1보다 작은 경우 IllegalArgumentException 처리")
    @ParameterizedTest(name="{displayName} | 입력값: {0}")
    @ValueSource(ints = {0, -1})
    public void 시도_횟수가_1보다_작은_경우(int param){
        assertThatThrownBy(() -> {
            RacingSetting racingSetting = new RacingSetting(param, param);
            Method method = racingSetting.getClass().getDeclaredMethod("validateTryRound", int.class);
            method.setAccessible(true);
            method.invoke(racingSetting, param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 1보다 큰 경우")
    @ParameterizedTest(name="{displayName} | 입력값: {0}")
    @ValueSource(ints = {2, 3, 4})
    public void 시도_횟수가_1보다_큰_경우(int param) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        RacingSetting racingSetting = new RacingSetting(param, param);
        Method method = racingSetting.getClass().getDeclaredMethod("validateTryRound", int.class);
        method.setAccessible(true);
        method.invoke(racingSetting, param);
    }

    @DisplayName("생성자와 주행 차량수 동일한 경우")
    @ParameterizedTest(name="{displayName} | 입력값: {0}")
    @ValueSource(ints = {2, 3, 4})
    public void 생성자와_주행차량수_동일체크(int param) {
        RacingSetting racingSetting = new RacingSetting(param, param);
        assertThat(racingSetting.getCarCount()).isEqualTo(param);
    }

    @DisplayName("생성자와 시도 횟수가 동일한 경우")
    @ParameterizedTest(name="{displayName} | 입력값: {0}")
    @ValueSource(ints = {2, 3, 4})
    public void 생성자와_시도_횟수_동일체크(int param) {
        RacingSetting racingSetting = new RacingSetting(param, param);
        assertThat(racingSetting.getTryRound()).isEqualTo(param);
    }

}