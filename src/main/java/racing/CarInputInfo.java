package racing;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarInputInfo {
    private Scanner scan = new Scanner(System.in);
    private CarRace carRace = new CarRace();

    CarRace getCarEntry() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String entry = scan.next();

        List<String> carEntry = Stream.of(entry.split(",")).collect(Collectors.toList());

        for (int i = 0; i < carEntry.size(); i++) {
            carRace.getCars().add(new Car(carEntry.get(i)));
        }

        return carRace;
    }

    int getTrackCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scan.nextInt();
    }
}