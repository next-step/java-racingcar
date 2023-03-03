package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String names = scanner.next();
        String[] namesArray = names.split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");

        int count = Integer.parseInt(scanner.next());
        System.out.println("실행결과");

        // ㅁㄴㅇㄻㄴㄹ
        List<Car> cars = new ArrayList<>();
        for (String name : namesArray) {
            cars.add(new Car(name));
        }

        // 차가 이동한다
        for (int i = 0; i < count; i++) {
            cars.forEach(Car::move);
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        
        Optional<Car> max = cars.stream().max((c1, c2) -> c1.compare(c1, c2));
        Car winner = max.get();

        List<Car> winners = cars.stream().filter(c -> c.isEqualLocation(winner)).collect(Collectors.toList());

        for (int i = 0; i < winners.size(); i++) {
            Car car = winners.get(i);
            System.out.print(car);

            if (i + 1 != winners.size()) {
                System.out.print(",");
            }
        }
    }
}
