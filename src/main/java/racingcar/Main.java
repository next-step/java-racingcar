package racingcar;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 대 인가요?");
        int tryCount = scanner.nextInt();
        System.out.println();
        System.out.println("실행 결과");
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) { // n개의 자동차를 리스트에 넣어준다.
            cars.add(new Car());
        }

        for (int i = 0; i < tryCount; i++) { // n번의 시도를 한다.
            for (int j = 0; j < carCount; j++) {
                int randomNo = new Random().nextInt(10);
                if (randomNo >= 4) {
                    cars.get(j).move();
                }
                for (int k = 0; k < cars.get(j).position; k++) {
                    System.out.print('-');
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
