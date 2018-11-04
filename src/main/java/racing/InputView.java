package racing;

import java.util.Scanner;

public class InputView {
    private static Scanner sc;

    InputView(Scanner scanner){
        this.sc = scanner;
    }

    public static int getTryCnt(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCnt = sc.nextInt();
        return tryCnt;
    }

    public static String getRacingCars(){
        System.out.println(" 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names =  sc.nextLine();
        return names;
    }




}
