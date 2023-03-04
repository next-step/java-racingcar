package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.next();
        String[] namesArray = names.split(",");
        List<Car> cars = makeCars(namesArray);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(scanner.next());

        Race race = new Race(cars, count);
        race.startRace();
        race.printRacingWinners();
    }

    private static List<Car> makeCars(String[] namesArray) {
        List<Car> cars = new ArrayList<>();
        for (String name : namesArray) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
