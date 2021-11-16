package racing.view;

import racing.domain.GetNameList;

import java.util.List;
import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static List<String> getNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameString = scanner.nextLine();
        GetNameList getNameList = new GetNameList(nameString);
        List<String> nameList = getNameList.getNameList();
        return nameList;
    }

    public static Integer getCuntOfTry() {
        System.out.println("시도할 횟수는?");
        return scanner.nextInt();
    }
}
