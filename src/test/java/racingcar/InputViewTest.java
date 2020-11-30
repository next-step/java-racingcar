package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


class InputViewTest {

    @Test
    @DisplayName("차량 대수 받는 테스트")
    public void carNumber(){
        InputView inputView = new InputView(new Scanner("5"));
        int carNumber = inputView.getMessageCarNumber();
        assertThat(carNumber).isEqualTo(5);
    }
    @Test
    @DisplayName("시도 할 횟수 테스트")
    public void tryNumber(){
        InputView inputView = new InputView(new Scanner("5"));
        int carNumber = inputView.getMessageCarNumber();
        assertThat(carNumber).isEqualTo(5);
    }


}