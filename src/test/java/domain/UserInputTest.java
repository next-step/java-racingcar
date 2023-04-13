package domain;

import static domain.UserInput.isOverOne;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputTest {


    @ParameterizedTest(name = "User 의 attempt 값이 0 이거나 음수이면 에러표시 : {0} 일 때")
    @ValueSource(ints = {0, -1, -2, -3})
    void isNotOverOne(int element) {
        assertThatThrownBy(() -> isOverOne(element))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 정수만 입력 가능합니다.");

    }

    @ParameterizedTest(name = "이름을 입력하고 , 를 구분자로 리스트를 만든다.")
    @ValueSource(strings = {"포비,크롱,뽀로로"})
    void getNames(String names) {
        UserInput userInput = new UserInput(names, 1);

        String[] namesForCars = userInput.getNamesForCars();

        assertThat(namesForCars[2]).isEqualTo("뽀로로");
        assertThat(userInput.getNumbersOfCar()).isEqualTo(3);
    }
}
