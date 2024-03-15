package carRacing;

import carRacing.view.InputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    @DisplayName("이름 미입력시 에러 발생 테스트")
    void inputName_null() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.inputName("");
        });

        System.out.print(exception.getMessage());
    }

    @Test
    @DisplayName("5자리 초과하는 이름 입력시 에러 발생 테스트")
    void inputName_lengthOver() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.inputName("7uuckssoo");
        });

        System.out.print(exception.getMessage());
    }
}

