package step3;

import java.util.Scanner;

public class InputView {

    static Integer[] inputMessage(){
        Integer[] userInputArray = new Integer[2];
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        userInputArray[0] = Integer.parseInt(scanner.nextLine());

        System.out.println("시도할 회수는 몇 회 인가요?");
        userInputArray[1] = Integer.parseInt(scanner.nextLine());

        System.out.println("레이싱 결과 출력 입니다.");

        return userInputArray;
    }

}
