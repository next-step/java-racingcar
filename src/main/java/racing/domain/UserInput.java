package racing.domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private UserInput() {
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = SCANNER.nextLine();

        try {
            List<String> names = splitStringByComma(input);
            checkCarCount(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }
    }

    public static List<String> splitStringByComma(String input) {
        List<String> names = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",");

        while (st.hasMoreTokens()) {
            String name = st.nextToken().trim();
            names.add(name);
        }
        return names;
    }

    public static void checkCarCount(List<String> names) {
        if (names.size() < 1) {
            throw new IllegalArgumentException("[ERROR] 최소 1대 이상의 자동차가 필요합니다.");
        }
    }

    public static int getTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tryNumber = Integer.parseInt(SCANNER.nextLine());
            checkTryNumber(tryNumber);
            return tryNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 해주세요.");
            return getTryNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryNumber();
        }
    }

    public static void checkTryNumber(int tryNumber) {
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 최소 1회 이상이어야 합니다.");
        }
    }
}
