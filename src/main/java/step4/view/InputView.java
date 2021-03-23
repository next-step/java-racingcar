package step4.view;

import step4.domain.Data;
import step4.util.InputValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    Data data;

    public void inputData() throws InputMismatchException {
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String names = scan.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scan.nextInt();

        data = InputValidator.validate(new Data(names, count));
    }

    public Data getData() {
        return data;
    }
}
