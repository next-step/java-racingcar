package racing;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarInputInfo {
    private Scanner scan = new Scanner(System.in);

    Cars getCarEntry() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String entry = scan.next();

        return new Cars(Stream.of(entry.split(",")).collect(Collectors.toList()));
    }

    int getTrackCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scan.nextInt();
    }

    private void display(final Car car) {
        System.out.print(car.getName() + ':');
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    void racing(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            cars.getCars().get(i).move(getRandomNumber());
            display(cars.getCars().get(i));
        }
        System.out.println();
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

    void winnersDisplay(Winners winners) {
        System.out.print("최종 우승자 : ");
        winners.getWinners().stream()
                .forEach(name -> System.out.print(name.getName() + ", "));
    }
}