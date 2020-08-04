<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 3f4f234... feat 자동차 대수, 시도 횟수 입력 기능 제작
package step3.view.output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
<<<<<<< HEAD
=======
>>>>>>> b195028... feat 자동차 대수, 시도 횟수 입력 기능 제작
=======
>>>>>>> 3f4f234... feat 자동차 대수, 시도 횟수 입력 기능 제작
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

<<<<<<< HEAD
<<<<<<< HEAD
    @Test
    @DisplayName("자동차 경주 경로 화면 출력")
    public void printingMovement() {
        OutputView.printingMovement(2);
        /* TODO: System.out 으로 사용하는 화면 출력은 어떻게 유닛 테스트를 제작할까?*/
    }
=======
>>>>>>> b195028... feat 자동차 대수, 시도 횟수 입력 기능 제작
=======
    @Test
    @DisplayName("자동차 경주 경로 화면 출력")
    public void printingMovement() {
        OutputView outputView = new OutputView();

        outputView.printingMovement(4);
        /* TODO: System.out 으로 사용하는 화면 출력은 어떻게 유닛 테스트를 제작할까?*/
    }
>>>>>>> 3f4f234... feat 자동차 대수, 시도 횟수 입력 기능 제작
}