package racing.domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserInput {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> nameList;

        try {
            nameList = splitStringByComma(input);
            checkCarCount(nameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }
        return nameList;
    }

    public static List<String> splitStringByComma(String input) {
        List<String> nameList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",");

        while (st.hasMoreTokens()) {
            String name = st.nextToken().trim();
            checkNameLength(name);
            nameList.add(name);
        }
        return nameList;
    }

    public static void checkNameLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                "[ERROR] 이름의 길이는 " + MIN_LENGTH + " ~ " + MAX_LENGTH + " 글자 까지만 가능합니다.");
        }
    }

    public static void checkCarCount(List<String> nameList) {
        if (nameList.size() < 1) {
            throw new IllegalArgumentException("[ERROR] 최소 1대 이상의 자동차가 필요합니다.");
        }
    }

    public static int getTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        Scanner sc = new Scanner(System.in);
        int tryNumber;

        try {
            tryNumber = sc.nextInt();
            checkTryNumber(tryNumber);
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] 숫자만 입력 해주세요.");
            return getTryNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryNumber();
        }
        return tryNumber;
    }

    public static void checkTryNumber(int tryNumber) {
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 최소 1회 이상이어야 합니다.");
        }
    }
}
