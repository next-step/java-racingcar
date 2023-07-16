package study.step3;

import study.step3.domain.Cars;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자에게 자동차 대수와 시도할 횟수에 대한 input 값을 입력받는다.
        final Scanner scanner = new Scanner(System.in);
        System.out.println("경주에 참여할 자동차의 대수를 입력해주세요.");
        final int numberOfCars = scanner.nextInt();

        System.out.println("경주의 총 라운드 횟수를 입력해주세요.");
        final int repeatCount = scanner.nextInt();

        // 2. 입력한 대수만큼 자동차를 생성한다.
        final Cars cars = new Cars(numberOfCars);

        // 3. 0 ~ 9 사이의 random 값을 생성한다.
        // 4. 랜덤 숫자가 4 이상이면 한 칸 전진하며, 입력한 횟수만큼 반복한다.
        // 5. 자동차의 상태를 화면에 출력한다.
    }
}
