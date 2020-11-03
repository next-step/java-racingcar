package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RealCarTest {
    @Test
    @DisplayName("이동 결과는 true 또는 false 가 나온다")
    void move(){
        RealCar realCar = new RealCar("blue");
        Set<Boolean> results = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            realCar.move();
            results.add(realCar.isMoved());
        }
        assertThat(results).contains(true, false);
    }

    @Test
    @DisplayName("자동차 이름이 5자가 넘으면 오류메시지를 출력한다.")
    public void whenCarNameOverFiveChar() {
        assertThatThrownBy(() -> new RealCar("yellow")) //
                .isInstanceOf(IllegalArgumentException.class) //
                .hasMessage("이름은 5자를 넘을 수 없습니다.");
    }
}
