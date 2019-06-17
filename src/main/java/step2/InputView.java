package step2;

import java.util.Scanner;

public class InputView {

    Scanner sc = new Scanner(System.in);

    public int setCarNumber(){

        System.out.println("자동차 대수는 몇대 인가요?");
        return sc.nextInt();
    }

    public int setTryCount(){

        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }

}
