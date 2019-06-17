package racing.inputter;

import racing.exception.ScanException;

import java.util.*;

public class SystemConsoleInputter implements Inputter {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int inputIntValue() {

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new ScanException("숫자를 입력해주세요", e);
        } catch (Exception e) {
            throw new ScanException("입력 도중 에러가 발생했습니다", e);
        }
    }

    @Override
    public List<String> inputDelimiterSeparatedStringValue(String delimiter) {
        // TODO : 예외처리

        String line = scanner.nextLine();

        try {
            return Arrays.asList(line.split(delimiter));
        } catch (Exception e) {
            throw new ScanException("변환도중 에러가 발생했습니다. 입력값=" + line + ", 구분자=" + delimiter, e);
        }
    }
}
