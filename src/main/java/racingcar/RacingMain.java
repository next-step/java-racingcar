package racingcar;

import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = Input.getCarNames(sc);

        System.out.println("시도할 회수는 몇회인가요?");
        int times = Input.getTimes(sc);
    }
}
