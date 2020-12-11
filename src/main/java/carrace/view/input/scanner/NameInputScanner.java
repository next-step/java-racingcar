package carrace.view.input.scanner;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class NameInputScanner implements InputScanner<String[]> {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String[] scan() {
        return scanner.nextLine().split(",");
    }

    @Override
    public String[] repeatScan(String message) {
        while(true) {
            try {
                System.out.println(message);
                String[] carNames = this.scan();
                NameValidator.validateCarNames(carNames);
                return carNames;
            } catch (PatternSyntaxException | NoSuchElementException ex) {
                System.out.println("이름 입력 양식이 올바르지 않습니다.");
            } catch (IllegalArgumentException ex) {
                System.out.println("자동차 이름이 5자 이상입니다.");
            }
        }
    }
}
