<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 3f4f234... feat 자동차 대수, 시도 횟수 입력 기능 제작
package step3.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

<<<<<<< HEAD
class InputViewTest {

    @Test
    @DisplayName("경주 사전 준비 출력 테스트")
    public void inputView() {
        int inputCarCount = 2;
        int inputCycleCount = 2;

        InputView.CAR_COUNT_VIEW.printQuestion();
//        inputCarCount = InputScanner.scanInput();
//        InputView.CAR_COUNT_VIEW.printCount(inputCarCount);

        InputView.CYCLE_COUNT_VIEW.printQuestion();
//        inputCycleCount = InputScanner.scanInput();
//        InputView.CYCLE_COUNT_VIEW.printCount(inputCycleCount);
        /* TODO: System.out 으로 사용하는 화면 입력은 어떻게 유닛 테스트를 제작할까?*/
    }
=======
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

>>>>>>> b195028... feat 자동차 대수, 시도 횟수 입력 기능 제작
=======

class InputViewTest {

    @Test
    @DisplayName("경주 사전 준비 출력 테스트")
    public void inputView() {
        int inputCarCount = 0;
        int inputCycleCount = 0;

        InputView.CAR_COUNT_VIEW.printQuestion();
        inputCarCount = InputScanner.scanInput();
        InputView.CAR_COUNT_VIEW.printCount(inputCarCount);

        InputView.CYCLE_COUNT_VIEW.printQuestion();
        inputCycleCount = InputScanner.scanInput();
        InputView.CYCLE_COUNT_VIEW.printCount(inputCycleCount);
        /* TODO: System.out 으로 사용하는 화면 입력은 어떻게 유닛 테스트를 제작할까?*/

//        assertThat(inputCarCount).isGreaterThan(0);
//        assertThat(inputCycleCount).isGreaterThan(0);
    }
>>>>>>> 3f4f234... feat 자동차 대수, 시도 횟수 입력 기능 제작
}