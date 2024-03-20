package carRacing.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public InputView() {}

    public int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return isPassNumber(scanner.nextInt());
    }

    public String carList() {
        System.out.println("차량 이름을 적어주세요");
        return scanner.nextLine();
    }

    public int moveCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return isPassNumber(scanner.nextInt());
    }

    private static int isPassNumber(int number){
        if(number<0){
            throw new IllegalArgumentException(String.format("허용되지 않은 숫자입니다. 입력 값 :[%s]", number));
        }
        return number;
    }
}
