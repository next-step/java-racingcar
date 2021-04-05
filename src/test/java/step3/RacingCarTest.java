package step3;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {
    
    RacingCar racing; 
    List<Boolean> moveConditions;

    @BeforeEach
    void setup() {
        try {
            String[] carNames = "frst,scnd,thrd".split(",");
            racing = new RacingCar(new Cars(carNames));

            moveConditions = new ArrayList<Boolean>();
            moveConditions.add(true);
            moveConditions.add(true);
            moveConditions.add(false);
            
            racing.raceSingleRound(moveConditions);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"true|1", "false|0"}, delimiter = '|')
    @DisplayName("차량의 전진 테스트")
    public void testMoveCaseOfTrue(boolean isMove, int position) {
        Car car = new Car();
        car.move(isMove);
        assertThat(car.getPosition()).isEqualTo(position);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"", "latte"})
    @DisplayName("차량의 명명규칙 검증 테스트")
    public void testCarNameLength(String name) {
        Car car = new Car();
        assertThatThrownBy(() -> car.setName(name)).isInstanceOf(IllegalStateException.class);
    }
    
    @Test
    @DisplayName("차량 레이싱 테스트")
    public void testRacing() {
        for( int index = 0 ; index < racing.getTotalCarCount() ; index++ ) {
            assertThat(racing.getCarByIndex(index).getPosition()).isEqualTo(moveConditions.get(index) ? 1 : 0);
        }
    }

    @Test
    @DisplayName("최대 전진 위치 반환 테스트")
    public void testMaxPosition() {
        assertThat(racing.getMaxPosition()).isEqualTo(1);
    }
}