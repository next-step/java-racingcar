package entity.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("생성자 Validation Test")
    public void 생성자_Validation_Test(){
        String blankName = "";
        String nullName = null;

        assertThatThrownBy(()->{
            CarName.from(blankName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름이 null값 이거나 빈 값일 수는 없습니다.");
        
        assertThatThrownBy(()->{
            CarName.from(nullName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름이 null값 이거나 빈 값일 수는 없습니다.");

    }
}