package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

public class CarTest {


    private InputView inputView = new InputView();
    @Test
    @DisplayName("4이상 랜덤값 1 반환 테스트")
    public void test1(){
        Car car = new CarAdvance();
        assertThat(car.goStop()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만 랜덤값 0 반환 테스트")
    public void test2(){
        Car car = new CarStop();
        assertThat(car.goStop()).isEqualTo(0);
    }

    @Test
    @DisplayName("car 객체 position 상태값 변경테스트")
    public void test4(){
        CarAdvance car = new CarAdvance();
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result = car.goStop();
        }
        assertThat(result).isEqualTo(3);
    }

}
