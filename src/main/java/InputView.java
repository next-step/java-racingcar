import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> readCarNamesInput() {
        Scanner scanner = new Scanner(System.in);
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.nextLine().split(",");

        List<String> carNames = new ArrayList<>();
        for (String name : names) {
            carNames.add(checkValidName(name));
        }
        return carNames;
    }

    public static int readRoundCountInput() {
        Scanner scanner = new Scanner(System.in);
        print("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private static String checkValidName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        return name;
    }

    private static boolean isValidName(String name) {
        return name.length() <= 5;
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
