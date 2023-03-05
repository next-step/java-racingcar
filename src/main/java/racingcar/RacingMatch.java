package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class RacingMatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String strMatchCars = scanner.nextLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = scanner.nextInt();

        String[] participantCarsName = strMatchCars.split(",");

        ArrayList<Car> cars = new ArrayList<>();

        for (String s : participantCarsName) {
            cars.add(new Car(s));
        }

        System.out.println("실행결과");
        for (int i = 0; i < attemptCount; i++) {
            cars.forEach(Car::move);
            System.out.println();
        }

        List<Car> winners = cars.stream()
                            .filter(i -> i.getPosition() == cars.stream().max(Comparator.comparingInt(Car::getPosition)).get().getPosition())
                            .collect(Collectors.toList())
                            ;

        System.out.print("최종우승자: ");
        for (int i=0;i<winners.size();i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i).getName());
        }
    }

}
