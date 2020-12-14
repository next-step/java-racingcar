package step3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHandler {

    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> getCarNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String text = scanner.nextLine();
        return Arrays.stream(text.split(","))
                .collect(Collectors.toList());
    }

    public int getRoundCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String text = scanner.nextLine();
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException | NullPointerException e) {
            return getRoundCount();
        }
    }

}

