package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.util.InputUtils;
import step4.vehicle.Cars;

public class CarRaceWithNameTest {
    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void 자동차_이름입력_테스트(){
        Cars car = new Cars(InputUtils.inputCarNameView());
    }

}
