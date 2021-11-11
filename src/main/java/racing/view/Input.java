package racing.view;

import racing.service.ConvertInput;
import racing.service.NameCheck;

import java.util.List;
import java.util.Scanner;

public class Input {

    public static List<String> getNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String nameString = scanner.nextLine();
        ConvertInput convertInput = new ConvertInput();
        List<String> nameList = convertInput.convertInput(nameString);
        while (NameCheck.nameCheck(nameList)) {
            System.out.println("길이가 5를 초과하는 이름이 있습니다, 다시 입력해주세요");
            nameString = scanner.nextLine();
            nameList = convertInput.convertInput(nameString);
        }
        return nameList;
    }

    public static Integer getCuntOfTry() {
        System.out.println("시도할 횟수는?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
