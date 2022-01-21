package racingcar.util;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Jung YoonSung <ybook2012@gmail.com>, Kim HyeonSik <hsik0225@gmail.com>, Kim JuWon
 * <kjw11077naver@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Console {

    /**
     * 자바 표준 입력(콘솔 입력)을 받아주는 java api
     */
    private static Scanner scanner = getScanner();

    private Console() {
    }

    /**
     * {@link Scanner#nextLine()} 결과를 반환하는 메소드.
     * <p>
     * 개행문자 전까지의 사용자가 입력한 문자열을 반환한다.
     * </p>
     *
     * @return {@link Scanner#nextLine()}
     * @throws NoSuchElementException scanner.nexLine()중 발생하는 예외
     * @throws IllegalStateException  scanner.nexLine()중 발생하는 예외
     */
    public static String readLine() {
        makeNewScannerIfScannerIsClosed();
        return scanner.nextLine();
    }

    private static void makeNewScannerIfScannerIsClosed() {
        if (Objects.isNull(scanner) || scannerIsClosed()) {
            scanner = getScanner();
        }
    }

    private static boolean scannerIsClosed() {
        try {
            Field sourceClosedField = Scanner.class.getDeclaredField("sourceClosed");
            sourceClosedField.setAccessible(true);
            return sourceClosedField.getBoolean(scanner);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("리플렉션 중 에러 발생");
        }
        return true;
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
