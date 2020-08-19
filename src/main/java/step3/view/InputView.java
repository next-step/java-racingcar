package step3.view;

import java.util.Scanner;

public class InputView {

    int carCount;
    int tryCount;

    public InputView(){
        getEventInfo();
    }

    private void getEventInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        tryCount = scanner.nextInt();
        System.out.println("");
    }

    public int getCarCount(){
        return carCount;
    }

    public int getTryCount(){
        return tryCount;
    }

}
