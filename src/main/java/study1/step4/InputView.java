package study1.step4;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getRacerList(){
        return getAnswer("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static int getRoundCnt(){
        return Integer.parseInt(getAnswer("시도할 회수는 몇회인가요?"));
    }

    private static String getAnswer(String text){
        System.out.println(text);
        return scanner.nextLine();
    }
}
