package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.Validate.*;

public class RacingTest {
    @DisplayName("자동차 대수와 이동 횟수는 자연수이고 2대 이상이어야 함")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void 입력값_확인(int input){ validInputMoveCount(input);}

    @DisplayName("2개의 차가 달리고 2번째 차량이 움직인 경우 테스트")
    @Test
    void 정상_작동_확인(){
        Strategy forwardStrategy = new Strategy(){
            @Override
            public boolean isMovable(){
                return true;
            }
        };

        List<Car> cars = new ArrayList<>();
        String names = "A,B,C";
        for(String name : names.split(",")){
            cars.add(new Car(name));
        }

        // 2번째 차량(index - 1)이 움직이도록 함
        cars.get(1).moveCar(forwardStrategy);

        assertThat(cars.get(0).getMoveCount()).isEqualTo(1);
        assertThat(cars.get(1).getMoveCount()).isEqualTo(2);
    }

    @DisplayName("자동차 이름은 5 글자를 넘기지 않아야 함")
    @ParameterizedTest
    @ValueSource(strings = {"adam", "brian", "frank"})
    void 자동차_이름_확인(String name){ validName(name); }

    @DisplayName("자동차 이름은 콤마(',')로 구분되어야 함")
    @Test
    void 자동차_구분자_확인(){ validInputNames("a,b,c"); }
}
