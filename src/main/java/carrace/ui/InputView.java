package carrace.ui;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] scanCarName() {
        return repeatScanName("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static int scanTryCount() {
        return repeatScanCount("시도할 회수는 몇 회 인가요?");
    }

    private static int repeatScanCount(String message) {
        int count;
        while(true) {
            try {
                System.out.println(message);
                count = scanCount();
                break;
            } catch (NumberFormatException ex) {
                System.out.println("입력은 숫자만 가능합니다.");
            }
        }
        return count;
    }

    private static int scanCount() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String[] repeatScanName(String message) {
        while(true) {
            try {
                System.out.println(message);
                return scanName();
            } catch (PatternSyntaxException | NoSuchElementException ex) {
                System.out.println("이름 입력 양식이 올바르지 않습니다.");
            } catch (IllegalArgumentException ex) {
                System.out.println("자동차 이름이 5자 이상입니다.");
            }
        }
    }

    private static String[] scanName() {
        String[] carNames = scanner.nextLine().split(",");
        validateCarNames(carNames);
        return carNames;
    }

    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    private static void validateCarName(String carName) {
        if(carName.length() > 5)
            throw new IllegalArgumentException();
    }
}
