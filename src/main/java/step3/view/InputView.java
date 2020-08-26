package step3.view;

import java.util.Scanner;

public class InputView {

    private String[] cars;
    private int tryCount;

    public void getEventInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        cars = scanner.nextLine().split(",");
        System.out.println("시도할 회수는 몇 회 인가요?");
        tryCount = Integer.parseInt(scanner.nextLine());
        System.out.println("");
    }

    public String[] getCars(){
        return cars;
    }

    public int getTryCount(){
        return tryCount;
    }

}
