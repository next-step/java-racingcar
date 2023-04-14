package entity.race;

import entity.car.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    @DisplayName("numberOfCar 유효성 테스트")
    public void validateNumberOfCar() {
        assertThatThrownBy(() -> {
            RacingCars.of(0, "test");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이스 차는 1대 이상 이어야 합니다.");
    }

    @Test
    @DisplayName("차_이름이_null_or_blank일때")
    public void 차_이름이_null_or_blank일때(){
        assertThatThrownBy(() -> {
            RacingCars.of(1, "");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 null 이거나 빈 칸입니다.");

        assertThatThrownBy(() -> {
            RacingCars.of(1, null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 null 이거나 빈 칸입니다.");
    }

    @Test
    @DisplayName("차이름과_갯수가_다를 때")
    public void 차이름과_갯수가_다를때(){
        assertThatThrownBy(() -> {
            RacingCars.of(2, "test");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 이름과 차량 갯수가 맞지 않습니다.");
    }

    @Test
    @DisplayName("차량_이름이_중복_될_때")
    public void 차량_이름이_중복_될_때(){
        assertThatThrownBy(() -> {
            RacingCars.of(2, "test,test");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차량 이름이 중복 됩니다.");
    }

    @Test
    @DisplayName("차량_이름은_5자를_초과할_수_없다")
    public void 차량_이름은_5자를_초과할_수_없다(){
        assertThatThrownBy(() -> {
            RacingCars.of(2, "testCar,testCar2");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차량 이름은 5글자를 초과 할 수 없습니다.");
    }
}