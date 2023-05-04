package car.view;

import java.util.Scanner;

public class InputView {

    public int inputIntegerValue(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return Integer.valueOf(value);
    }

    public String inputStringValue(){
        System.out.println("경주할 자동차 이름을 입력하세요");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return value;
    }

    public String[] carAttendNameSeparation(String value){
        return value.split(",");
    }

}
