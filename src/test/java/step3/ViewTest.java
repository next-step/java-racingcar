package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class ViewTest {

    @Test
    @DisplayName("자동차 수 입력 확인")
    public void checkInputCars() {
        String input = "6";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream); //System.in을 inputStream으로 변경
        assertThat(InputView.putNumOfCars()).isEqualTo(6);
    }

    @Test
    @DisplayName("시도 횟수 입력 확인")
    public void checkInputAttempts() {
        String input = "4";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream); //System.in을 inputStream으로 변경
        assertThat(InputView.putNumOfAttempts()).isEqualTo(4);
    }

}
