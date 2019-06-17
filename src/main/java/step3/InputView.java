package step3;

import java.util.Scanner;

public class InputView {

    static String[] inputMessage(){
        String[] userInputArray = new String[2];
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주 할 자동차 이름을 입력하세요(이름은 쉼표(,)로 구분)");
        userInputArray[0] = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        userInputArray[1] = scanner.nextLine();

        System.out.println("레이싱 결과 출력 입니다.");
        System.out.println();

        return userInputArray;
    }

}
