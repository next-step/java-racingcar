package mission1.step3.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static mission1.step3.command.Command.GO;
import static mission1.step3.command.Command.STOP;

public class CommandTest {

    @DisplayName("시행횟수 만큼의 커맨드 리스트 생성")
    @ParameterizedTest
    @CsvSource({"2, 2", "3, 3"})
    public void insertInappositeValue(int input, int result) {
        assertEquals(CommandFactory.createCommandList(input).size(), result);
    }

    @DisplayName("전진 커맨드 생성 체크")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    public void createGoCommand(int input) {
        assertEquals(GO, CommandFactory.getCommand(input));
    }

    @DisplayName("멈춤 커맨드 생성 체크")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void createStopCommand(int input) {
        assertEquals(STOP, CommandFactory.getCommand(input));
    }
}


