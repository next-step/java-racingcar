package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.type.CarName;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car mySummerCar;

    @BeforeEach
    public void beforeEach() {
        mySummerCar = Car.create(new CarName("masum"), 3);
    }

    @Test
    @DisplayName("[Car.move] 양의 정수 이동 시 -> 현 위치에서 그만큼 더해진 위치까지 이동")
    public void forwardCar() {
        mySummerCar.move(4);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(7);
    }

    @Test
    @DisplayName("[Car.move] 음의 정수 이동 시 -> 현 위치에서 그만큼 빼진 위치까지 이동")
    public void backwardCar() {
        mySummerCar.move(-2);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("[Car.move] 0 이동 시 -> 현 위치에서 고수")
    public void stopCar() {
        mySummerCar.move(0);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("[Car.move] 음의 위치로 이동 시도 시 -> IllegalArgumentException 던짐")
    public void unrealisticMove() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            mySummerCar.move(-5);
        });
    }

    @Test
    @DisplayName("[Car.getName] 생성 시 부여한 이름 조회 가능해야 함")
    public void carName() {
        assertThat(mySummerCar.getName())
                .isEqualTo(new CarName("masum"));
    }

    @Test
    @DisplayName("[Car] 자동차 생성 시 이름 6글자 ->  IllegalArgumentException 던짐")
    public void longCarName() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car.createWithName(new CarName("123456"));
        });
    }
}
