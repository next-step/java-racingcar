package car;

import car.Impl.MoveOver;
import car.Impl.MoveUnder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car = new Car();
    private InputView inputView = new InputView();
    @Test
    @DisplayName("4이상 랜덤값 TRUE 반환 테스트")
    public void test1(){
        Move move = new MoveOver();
        assertThat(car.goStop(move.MoveRandem())).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만 랜덤값 FALSE 반환 테스트")
    public void test2(){
        Move move = new MoveUnder();
        assertThat(car.goStop(move.MoveRandem())).isEqualTo(0);
    }

    @Test
    @DisplayName("스케너 입력값 숫자 반환 테스트")
    public void test3(){
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        assertThat(inputView.inputValue()).isEqualTo(3);
    }

    @Test
    @DisplayName("int값 크기로 int배열 생성")
    public void test4(){
        assertThat(car.createIntArray(3).length).isEqualTo(3);
    }

    @Test
    @DisplayName("전진일 경우 배열에 +1")
    public void test5(){
        Move move = new MoveOver();
        int[] cars = new int[3];
        cars = move.moveState(cars);
        System.out.println("--------cars : "+cars[0]);
        assertThat(cars[0]).isEqualTo(1);
        assertThat(cars[1]).isEqualTo(1);
        assertThat(cars[2]).isEqualTo(1);
    }

    @Test
    @DisplayName("멈춤일 경우 배열에 0")
    public void test6(){
        Move move = new MoveUnder();
        int[] cars = new int[3];
        cars = move.moveState(cars);
        System.out.println("--------cars : "+cars[0]);
        assertThat(cars[0]).isEqualTo(0);
        assertThat(cars[1]).isEqualTo(0);
        assertThat(cars[2]).isEqualTo(0);
    }
}
