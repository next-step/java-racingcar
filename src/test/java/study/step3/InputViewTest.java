package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView();
    }

    @Test
    public void 출력테스트 () throws Exception {
        inputView.inputNumberOfCars();
    }

}
