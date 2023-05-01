package RacingCarGame.entity.car;

import entity.car.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("생성자 Validation Test")
    public void 생성자_Validation_Test(String name){
        assertThatThrownBy(()->{
            new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름이 null값 이거나 빈 값일 수는 없습니다.");
    }
}