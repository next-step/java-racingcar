package racingcar.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameInfoTest {

    CarNameInfo carNameInfo;

    @Test
    void carNameIsBlankExceptionTest(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarNameInfo(""))
                .withMessage("차의 이름은 공백이 아니여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567", "12345678"})
    void carNameLengthOver5ExceptionTest(String carName){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarNameInfo(carName))
                .withMessage("차의 이름의 최대 길이는 5입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1", "car2", "car3"})
    void validCarNameTest(String carName){
        carNameInfo = new CarNameInfo(carName);
        assertThat(carNameInfo.get()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2", "car1,car2", "car1,car2,car3"})
    void createListFromInputTest(String input){
        String[] carNames = input.split(",");
        List<CarNameInfo> carNameInfoList = CarNameInfo.createListFromInput(carNames);
        assertThat(carNameInfoList.size()).isEqualTo(carNames.length);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car1", "car1,car2,car1", "car2,car1,car1"})
    void createListFromInputDuplicateTest(String input){
        String[] carNames = input.split(",");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameInfo.createListFromInput(carNames))
                .withMessage("이름이 중복된 차가 있습니다.");
    }
}