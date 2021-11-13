package racing.view;

import racing.service.InputBuilder;

import java.util.List;
import java.util.Scanner;

public class Input {

    private Input() {
    }

    private static Scanner scanner = new Scanner(System.in);

    public static List<String> getNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameString = scanner.nextLine();
        InputBuilder inputBuilder = new InputBuilder(nameString);
        List<String> nameList = inputBuilder.getNameList();
        return nameList;
    }

    public static Integer getCuntOfTry() {
        System.out.println("시도할 횟수는?");
        return scanner.nextInt();
    }
}
