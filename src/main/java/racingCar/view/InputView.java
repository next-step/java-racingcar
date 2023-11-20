package racingCar.view;

import java.util.List;
import racingCar.common.Symbol;
import racingCar.util.converter.Converter;
import racingCar.view.printer.Printer;
import racingCar.view.reader.Reader;
import racingCar.view.validator.InputValidator;

public class InputView {
    private static final String PLAYER_SEPARATOR = Symbol.COMMA;
    private final Reader reader;
    private final Printer printer;
    private final InputValidator validator;

    private InputView(Reader reader, Printer printer, InputValidator validator) {
        this.reader = reader;
        this.printer = printer;
        this.validator = validator;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer, InputValidator.getInstance());
    }

    public List<String> inputPlayer() {
        printer.printLine("플레이어의 이름은 ,로 구분된 형식으로 입력해야합니다. 예) pobi,crong,honux");
        String playerGroup = reader.readLine();
        validator.validatePlayerGroup(PLAYER_SEPARATOR, playerGroup);
        return Converter.splitToList(PLAYER_SEPARATOR, playerGroup);
    }
}
