package racingcargame;

import java.util.Scanner;

public class InputView {

    private Scanner sc;

    public int inputCarCount() {
        sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요? (10 이하 숫자만 입력)");
        return sc.nextInt();
    }

    public String inputCarName(int carNumber) {
        sc = new Scanner(System.in);
        System.out.println(carNumber + "번째 자동차 이름을 입력하세요. (5자 이하)");
        return sc.next();
    }

    public int inputTryCount() {
        sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        return sc.nextInt();
    }
}