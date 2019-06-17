package racing.inputter;

import racing.exception.ScanException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemConsoleInputter implements Inputter {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int getIntValue() {

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new ScanException("숫자를 입력해주세요", e);
        } catch (Exception e) {
            throw new ScanException("입력 도중 에러가 발생했습니다", e);
        }
    }

    @Override
    public String getStringValue() {

        try {
            return scanner.nextLine();
        } catch (Exception e) {
            throw new ScanException("입력 도중 에러가 발생했습니다", e);
        }
    }
}
