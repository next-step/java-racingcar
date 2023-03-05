package racingcar;

import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        String[] racingCars = inputLine.split(",");
        Racing racing = new Racing(racingCars);
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputLine2 = sc.nextLine();
        racing.run(Integer.parseInt(inputLine2));
        racing.printFinalWinner();
    }
}
