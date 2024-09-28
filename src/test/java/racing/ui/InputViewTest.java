package racing.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.ui.InputView;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    @DisplayName("input 메서드 실행 시, 입력한 숫자를 반환해야한다.")
    void input_메서드_테스트(){
       Scanner scanner = new Scanner("3");
       InputView view = new InputView(scanner);

       int number = view.input();

       assertThat(number).isEqualTo(3);
    }




}
