package step3.view.output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    @DisplayName("자동차 경주 경로 화면 출력")
    public void printingMovement() {
        OutputView.printingMovement(2);
        /* TODO: System.out 으로 사용하는 화면 출력은 어떻게 유닛 테스트를 제작할까?*/
    }
}