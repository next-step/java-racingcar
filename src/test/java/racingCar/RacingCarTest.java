package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.domain.RacingCar;
import racingCar.domain.ForwardPolicy;
import racingCar.ui.PrintService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @DisplayName("차량 전진 테스트")
    @Test
    void 차량_전진_테스트() {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.showDrivenDistance()).isEqualTo(0);
        racingCar.goForward();
        assertThat(racingCar.showDrivenDistance()).isEqualTo(1);
    }

    @DisplayName("레이싱카의 주행거리를 -로 변환하는 테스트")
    @Test
    void 주행거리_변환_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PrintService printService = new PrintService();
        Method method = printService.getClass().getDeclaredMethod("getDistance", int.class);
        method.setAccessible(true);
        assertThat(method.invoke("printService", 3)).isEqualTo("---");
    }

    @Test
    void 차량_상태_출력() {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.showDrivenDistance()).isEqualTo(0);
    }

}
