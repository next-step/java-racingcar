package racingcar.view;

import racingcar.domain.Utility;

import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<String> getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 , 기준으로 구분)");
        String participants = Utility.removeEmptySpaceFromName(scanner.nextLine()); // 공백 지우기
        return Utility.nameStringToArray(participants);
    }

    public int getLaps() {
        System.out.println("숫자 입력");
        return scanner.nextInt();
    }
}
