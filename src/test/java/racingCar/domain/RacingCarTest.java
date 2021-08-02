package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.ui.PrintService;

public class RacingCarTest {

    @DisplayName("차량 전진 테스트")
    @Test
    void 차량_전진_테스트() {
        RacingCar racingCar = new RacingCar("tesla");
        racingCar.goForward(4);
        assertThat(racingCar.showDrivenDistance()).isEqualTo(1);
    }

    @DisplayName("차량 정지 테스트")
    @Test
    void 차량_정지_테스트() {
        RacingCar racingCar = new RacingCar("tesla");
        racingCar.goForward(3);
        assertThat(racingCar.showDrivenDistance()).isEqualTo(0);
    }

    @DisplayName("차량 부분 전진 테스트")
    @Test
    void 차량_부분_전진_테스트() {
        RacingCar racingCar = new RacingCar("tesla");
        int[] numbers = new int[]{3, 3, 3, 4, 4};
        for (int i = 0; i < numbers.length; i++) {
            racingCar.goForward(numbers[i]);
        }
        assertThat(racingCar.showDrivenDistance()).isEqualTo(2);
    }

    @DisplayName("레이싱카의 주행거리를 -로 변환하는 테스트")
    @Test
    void 주행거리_변환_테스트()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PrintService printService = new PrintService();
        Method method = printService.getClass().getDeclaredMethod("getDistance", int.class);
        method.setAccessible(true);
        assertThat(method.invoke("printService", 3)).isEqualTo("---");
    }

    @DisplayName("차량 생성시 상태 테스트")
    @Test
    void 차량_상태_출력() {
        RacingCar racingCar = new RacingCar("tesla");
        assertThat(racingCar.showDrivenDistance()).isEqualTo(0);
    }

    @DisplayName("차량 이름 설정 테스트")
    @Test
    void car_name_test() {
        RacingCar racingCar = new RacingCar("Tesla");
        assertThat(racingCar.getCarName()).isEqualTo("Tesla");
    }
}
