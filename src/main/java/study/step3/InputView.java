package study.step3;

<<<<<<< HEAD
import java.util.Scanner;

public class InputView {
    private final static String CAR_TEXT ="자동차";
    private final static String TRY_TIME_TEXT ="시도";
    private final static String CAR_INPUT_QUESTION =" 대수는 몇 대 인가요?";
    private final static String TRY_TIME_INPUT_QUESTION =" 회수는 몇 회 인가요?";
    private final static String DELIMITER =":";
    private final static String ILLEGALARGUMENT_EXCEPTION_MASSEAGE = "올바르지 않은 값을 입력했습니다.";
    private final static String ILLEGALARGUMENT_VALIDATE_MASSEAGE = "보다는 큰 값을 입력해야 합니다.";
    private final static Scanner scanner = new Scanner(System.in);

    public static int inputCarNumber(){
        System.out.println(CAR_TEXT + CAR_INPUT_QUESTION);
        return inputIntNumber(CAR_TEXT);
    }

    public static int inputTryTime() {
        System.out.println(TRY_TIME_TEXT + TRY_TIME_INPUT_QUESTION);
        return inputIntNumber(TRY_TIME_TEXT);
    }

    private static int inputIntNumber(String targetText) {
        if (scanner.hasNextInt()) {
            return valitate(targetText, scanner.nextInt());
        }
        throw new IllegalArgumentException(targetText + DELIMITER + ILLEGALARGUMENT_EXCEPTION_MASSEAGE);
    }

    private static int valitate(String targetText, int nextInt) {
        if (nextInt <= 1){
            throw new IllegalArgumentException(targetText + DELIMITER +nextInt+ ILLEGALARGUMENT_VALIDATE_MASSEAGE);
        }
        return nextInt;
    }
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private final static String CAR_INPUT_QUESTION ="자동차 대수는 몇 대 인가요?";
    private final static String TRY_TIME_INPUT_QUESTION ="시도할 회수는 몇 회 인가요?";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCarNumber(){
        System.out.println(CAR_INPUT_QUESTION);
        return scanner.nextLine();
    }

    public String inputTryTime() {
        System.out.println(TRY_TIME_INPUT_QUESTION);
        return scanner.nextLine();
    }

>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
}
