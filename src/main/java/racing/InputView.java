package racing;

import java.util.Scanner;

public class InputView {
    private static Scanner sc;

    InputView(Scanner scanner){
        this.sc = scanner;
    }

    public static int getRacingCarCnt(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt =  sc.nextInt();
        return carCnt;
    }

    public static int getTryCnt(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCnt = sc.nextInt();
        return tryCnt;
    }

}
