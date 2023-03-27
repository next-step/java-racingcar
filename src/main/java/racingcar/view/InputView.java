package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String racingCarsInput = sc.nextLine();
        return racingCarsInput.split(",");
    }
    public static int getTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner sc = new Scanner(System.in);
        String tryCount = sc.nextLine();
        return Integer.parseInt(tryCount);
    }
}
