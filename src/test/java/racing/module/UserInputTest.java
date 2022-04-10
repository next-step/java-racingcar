package racing.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Car;

class UserInputTest {

    private UserInput userInput;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        userInput = new UserInput(sc);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("자동차 대수에 대한 사용자 입력 테스트")
    void settingCarsByUserInputTest(){
        List<Car> cars = userInput.settingCarsByUserInput();
        assertThat(cars).hasSize(5);
        assertEquals("자동차 대수는 몇 대 인가요?\n", outputStreamCaptor.toString());
    }

    @Test
    @DisplayName("시도 횟수에 대한 사용자 입력 테스트")
    void settingTurnCountByUserInputTest(){
        assertThat(userInput.settingTurnCountByUserInput()).isEqualTo(5);
        assertEquals("시도할 회수는 몇 회 인가요?\n", outputStreamCaptor.toString());

    }

}