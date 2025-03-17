package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = List.of(scanner.next().split(",")); // 첫 번째 값 입력받음

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRounds = scanner.nextInt(); // 두 번째 값 입력받음

        System.out.println("\n실행결과");

        Racing racing = new Racing(carNames.stream().map(Car::new).collect(Collectors.toList()));
        for (int i = 0; i < numberOfRounds; i++) {
            racing.playRound();
            System.out.println(ResultView.printCarsDistance(racing.getCars()));
            System.out.println();
        }
    }
}
