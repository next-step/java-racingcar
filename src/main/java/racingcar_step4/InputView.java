package racingcar_step4;

import com.google.common.base.Splitter;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    public static String[] getCarNames() throws RuntimeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return parseCarNames(scanner.nextLine());
    }

    public static int getRacingCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");

        return Integer.parseInt(scanner.nextLine());
    }

    private static String[] parseCarNames(String text) throws RuntimeException {
        String[] names = new String[0];

        if (checkPattern(text)) {
            names = Splitter.on(',').splitToList(text).toArray(names);
        }
        return names;
    }

    public static boolean checkPattern(String text) throws RuntimeException {
        Pattern pattern = Pattern.compile("^\\s*(([가-힣a-zA-Z0-9]+),)+([가-힣a-zA-Z0-9]+)+\\s*$");
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            throw new IllegalArgumentException("입력값 오류");
        }
        return true;
    }
}
