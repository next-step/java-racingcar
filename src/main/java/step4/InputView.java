package step4;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private int inputTime;
    private Scanner scanner;
    private String[] nameList;

    public InputView(Scanner scan){
        scanner = scan;
    }

    public void getUserInput() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameString = this.scanner.next();

        nameList = ParserUtils.stringToArray(carNameString);
        ParserUtils.checkBlank(nameList);

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputTime = this.scanner.nextInt();

        if (inputTime < 1) {
            throw new IllegalArgumentException("반복횟수가 0보다 작을 수 없습니다.");
        }


    }
    public int getInputTime(){
        return this.inputTime;
    }
    public String[] getnameList(){
        return this.nameList;
    };
}
