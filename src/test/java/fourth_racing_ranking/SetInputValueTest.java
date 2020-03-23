package fourth_racing_ranking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SetInputValueTest {
    private SetInputValue setInputValue = new SetInputValue();
    private String systemInStringValue = "";
    private int systemInIntValue= 0;

    @ParameterizedTest
    @ValueSource( strings = {"pobi,crong,honux"} )
    @DisplayName("자동차 입력값 테스트")
    void carNameInputTest(String testInput) {
        String carName = "pobi";
        System.setIn(new ByteArrayInputStream(systemInStringValue.getBytes()));
        String[] splitCarName =
                setInputValue.splitCarName(testInput);
        assertThat(splitCarName[0]).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 초기 세팅 객체테스트")
    void setCarTest(){
        String[] testInput = {"pobi", "crong", "honux"};
        System.setIn(new ByteArrayInputStream(systemInStringValue.getBytes()));
        List<Car> car = setInputValue.setCar(testInput);
        assertThat(car.get(0).getCarName()).isEqualTo("pobi");
        assertThat(car.get(0).getCarPosition()).isEqualTo(1);
    }
}
