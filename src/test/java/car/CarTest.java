package car;

import car.Impl.MoveOver;
import car.Impl.MoveUnder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car = new Car();
    @Test
    @DisplayName("4이상 랜덤값 TRUE 반환 테스트")
    public void test1(){
        Move move = new MoveOver();
        assertThat(car.goStop(move.MoveRandem())).isEqualTo(true);
    }

    @Test
    @DisplayName("4미만 랜덤값 FALSE 반환 테스트")
    public void test2(){
        Move move = new MoveUnder();
        assertThat(car.goStop(move.MoveRandem())).isEqualTo(false);
    }
}
