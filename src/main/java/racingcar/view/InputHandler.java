package racingcar.view;

import racingcar.utils.Utils;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        String input = sc.nextLine();
        return Utils.nameAnalysis(input);
    }

    public static int getTryCnt(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = sc.nextLine();
        return Utils.tryAnalysis(input);
    }
}
