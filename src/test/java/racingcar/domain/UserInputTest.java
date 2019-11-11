package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.UserInput;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {

    @Test
    @DisplayName("','로 구분지어 받은 자동차이름을 파싱하여 리스트로 반환한다.")
    void getCarNameList() {

        //given
        String names = "a,b,c";
        int runNunmber = 5;
        UserInput input = new UserInput(names, runNunmber);

        //when
        List<String> carNameList = input.getCarNames();

        //then
        assertThat(carNameList).hasSize(3);
        assertThat(carNameList).containsExactly("a", "b", "c");

    }
}
