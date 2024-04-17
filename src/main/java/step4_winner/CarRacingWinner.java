package step4_winner;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRacingWinner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesWithComma = scanner.next();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTries = scanner.nextInt();

        String[] carNames = carNamesWithComma.split(",");

        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());

        Race race = new Race(cars);

        System.out.print("실행 결과\n");
        for(int i = 0; i < numberOfTries; i++) {
            race.runRound();
            cars.forEach(car -> System.out.println(car.getName()+" : "+"-".repeat(car.getDistance())));
            System.out.println();
        }

        // 최대 거리 찾기
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalStateException("List is empty "));
        String winners = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winners+"가 최종 우승했습니다.");
    }
}
