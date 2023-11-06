package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.validite.ValidityCheck;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidityCheckTest {

    @Test
    public void 자동차이름_입력() {
        //given
        List<String> carName = List.of("pobi","crong","honux");
        //when
        int carList = ValidityCheck.carNameCheck(carName).size();
        //then
        assertThat(carList).isEqualTo(3);
    }

    @Test
    public void 시도횟수_입력_숫자() {
        //given
        int number = 2;
        //when
        //then
        assertThat(ValidityCheck.positiveNumberCheck(number)).isEqualTo(number);
    }

    @Nested
    @DisplayName("입력값이 숫자가 아닌값 테스트")
    class ValidityCheckFaild {

        @Test
        public void 시도횟수_입력_음수() {
            //given
            //when
            //then
            assertThatThrownBy(() -> ValidityCheck.positiveNumberCheck(-1)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void 시도횟수_입력_문자() {
            //given
            String invalidNumber = "a";
            //when
            //then
            assertThatThrownBy(() -> ValidityCheck.positiveNumberCheck(Integer.parseInt(invalidNumber))).isInstanceOf(NumberFormatException.class);
        }
    }

    @Nested
    @DisplayName("자동차이름 입력값 테스트")
    class CarNameFaildTest {
        @Test
        public void 자동차이름_입력_이름_초과() {
            //given
            List<String> carName = List.of("pobi","crongh");
            //when
            //then
            assertThatThrownBy(() -> ValidityCheck.carNameCheck(carName)).isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        public void 자동차이름_입력_쉼표_연속() {
            //given
            List<String> carName = List.of("pobi","","crong","honux");
            //when
            //then
            assertThatThrownBy(() -> ValidityCheck.carNameCheck(carName)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void 자동차이름_입력_쉼표_시작() {
            //given
            List<String> carName = List.of("","pobi","crong","honux");
            //when
            //then
            assertThatThrownBy(() -> ValidityCheck.carNameCheck(carName)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
