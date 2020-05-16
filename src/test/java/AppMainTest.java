import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class AppMainTest {

    @Test
    @DisplayName("숫자 외 문자를 입력할 경우")
    void scannerTest() {
        Scanner scanner = new Scanner("count");
        assertThatExceptionOfType(InputMismatchException.class).isThrownBy(() ->{
            print("자동차 대수는 몇 대 인가요?");
            String carNames = scanner.nextLine();
            print("시도할 회수는 몇 회 인가요?");
            int time = scanner.nextInt();
        }).describedAs("시도할 회수는 숫자를 입력하세요");
    }

    public static void print(String text) {
        System.out.println(text);
    }

}
