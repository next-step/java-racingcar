package step5.view;

import java.util.Scanner;

public class InputView {

    private String[] names;
    private int tryCount;

    public void input(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        names = splitNames(scanner.nextLine());

        System.out.println("시도할 횟수는 몇 회 인가요?");
        tryCount = scanner.nextInt();
    }

    private String[] splitNames(String input) {
        return input.split(",");
    }

    public String[] getNames() {
        return names;
    }

    public int getTryCount() {
        return tryCount;
    }
}
