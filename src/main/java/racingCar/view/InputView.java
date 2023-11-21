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
        printer.printLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String playerGroup = reader.readLine();

        validator.validatePlayerGroup(PLAYER_SEPARATOR, playerGroup);
        return Converter.splitToList(PLAYER_SEPARATOR, playerGroup);
    }

    public int inputTryCount() {
        printer.printLine("시도할 회수는 몇회인가요?");
        String tryCount = reader.readLine();

        validator.validateTryCount(tryCount);
        return Converter.convertToInt(tryCount);
    }
}
