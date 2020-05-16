package study.step3;

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

}
