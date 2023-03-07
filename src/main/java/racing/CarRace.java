package racing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRace {
    private String carListText;     // 자동차 이름 리스트
    private int trackCount;         // 주행할 트랙수
    int maxDistance;
    List<String> winners;
    private Scanner scan = new Scanner(System.in);

    List<String> getRacingJoinList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        carListText = scan.next();

        return Stream.of(carListText.split(","))
                .map(String::trim).collect(Collectors.toList());
    }

    void getTrackCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.trackCount = scan.nextInt();
    }

    int getTotalTrackCount() {
        return trackCount;
    }

    void runningRace(ArrayList<Car> carArrayList) {
        for (int i = 0; i < carArrayList.size(); i++) {
            carArrayList.get(i).carRun(getRandomNumber());
            carArrayList.get(i).statusPrint();
            confirmWinners(carArrayList.get(i));
        }
    }

    void confirmWinners(Car car) {
        if (maxDistance < car.getDistance()) {
            maxDistance = car.getDistance();
            winners = new ArrayList<>();
        }

        if (maxDistance == car.getDistance()) {
            winners.add(car.getCarName());
        }
    }

    String winnersPrint() {
        String winners = "최종 우승자 : " + this.winners.toString();
        System.out.println(winners);
        return winners;
    }

    int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
