package step3.view;

import step3.Constant;

import java.util.Scanner;

public class InputView {

    private String[] cars;
    private int tryCount;

    public void getEventInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.INPUT_RACING_CAR_NAMES);
        cars = scanner.nextLine().split(",");
        System.out.println(Constant.INPUT_TRY_COUNT);
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
