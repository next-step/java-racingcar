package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.view.ResultView;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ResultViewTest {

    @Test
    @DisplayName("자동차 이동표시 빈 값 전달")
    public void displayMove(){
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(()->{new ResultView().displayMove(null);});
    }


}
