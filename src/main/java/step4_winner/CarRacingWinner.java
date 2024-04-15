package step4_winner;

import java.util.Arrays;
import java.util.Scanner;

public class CarRacingWinner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesWithComma = scanner.next();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTries = scanner.nextInt();

        String[] carNames = carNamesWithComma.split(",");

        System.out.print("실행 결과\n");
        System.out.println("cars: "+carNames.length);
        System.out.println("tries: "+numberOfTries);
        System.out.println("carlist:");
        Arrays.stream(carNames).forEach(System.out::println);
    }
}
