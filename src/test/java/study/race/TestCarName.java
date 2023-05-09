package study.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCarName {


    @ParameterizedTest(name = "CarName 객체 - null 값 테스트")
    @NullAndEmptySource
    public void test_carname_constructor_null(String testCarName) {
        assertThatThrownBy(() -> new CarName(null))
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("자동차 이름을 입력해주세요.");
    }
    

    @Test()
    @DisplayName("CarName 객체 - 이름 최대 길이 유효성")
    public void test_carname_max_length() {
        String testCarName = "123456";
        assertThatThrownBy(() -> new CarName(testCarName))
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("자동차 이름은 1~5자만 가능합니다.");
    }


    @ParameterizedTest(name = "CarName 객체 - 정상 생성 테스트")
    @ValueSource(strings = {"car1", "car2", "car3"})
    public void test_carname_get_name(String inputName) {
        CarName carName = new CarName(inputName);

        assertThat(carName.getName()).isEqualTo(inputName);
    }

}
