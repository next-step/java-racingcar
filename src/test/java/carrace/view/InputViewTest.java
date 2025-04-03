package carrace.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {

    @DisplayName("자동차 대수가 0이하의 값이면, 에러가 발생합니다.")
    @Test
    public void receiveCarNumTest_Negative() {
        InputView inputView = new InputView();
        int negativeNumCar = -1;
        assertThatThrownBy(() -> inputView.receiveCarNum(negativeNumCar))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("자동차 대수는 1대 이상의 값이면 아무 문제가 없습니다.")
    @Test
    public void receiveCarNumTest_Positive() {
        InputView inputView = new InputView();
        int positiveNumCar = 2;

        assertThat(inputView.receiveCarNum(positiveNumCar)).isEqualTo(positiveNumCar);
    }

    @DisplayName("자동차 이름이 6글자 이상이면 에러가 발생합니다.")
    @Test
    public void receiveCarNamesTest_6char() {
        InputView inputView = new InputView();
        String inputCarNames = "6charCarName,pobi,crong";

        assertThatThrownBy(() -> inputView.receiveCarNames(inputCarNames))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("콤마를 기준으로 스플릿하였을때, 자동차 수는 2대 이상이어야합니다.")
    @Test
    public void receiveCarNamesTest_carNumleqThanTwo() {
        InputView inputView = new InputView();
        String inputCarNames = "car1";

        assertThatThrownBy(() -> inputView.receiveCarNames(inputCarNames))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("콤마를 기준으로 스플릿되어야합니다.")
    @Test
    public void receiveCarNamesTest_commaSplit() {
        InputView inputView = new InputView();
        String inputCarNames = "car1,car2,car3";
        String[] expectedCarNames = {"car1", "car2", "car3"};

        assertThat(inputView.receiveCarNames(inputCarNames)).containsExactly(expectedCarNames);
    }

    @DisplayName("시도 회수가 0 이하의 값이면, 에러가 발생합니다.")
    @Test
    public void receiveNumTryTest_Negative() {
        InputView inputView = new InputView();
        int negativeNumTry = -1;

        assertThatThrownBy(() -> inputView.receiveNumTry(negativeNumTry))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("시도 회수가 0 이하의 값이면, 에러가 발생합니다.")
    @Test
    public void receiveNumTryTest_Postive() {
        InputView inputView = new InputView();
        int positiveNumTry = 2;

        assertThat(inputView.receiveNumTry(positiveNumTry)).isEqualTo(positiveNumTry);
    }
}
