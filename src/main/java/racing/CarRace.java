package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRace {
    String carListText;     // 자동차 이름 리스트
    int trackCount;         // 주행할 트랙수
    static int maxDistance;
    List<String> winners = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

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

    void runningRace(Car[] carArr) {
        for(int i=0; i < carArr.length; i++) {
            carArr[i].carRacing();
            getMaxDistance(carArr[i]);
        }
    }

    void getMaxDistance(Car car) {
        if(maxDistance < car.getDistance()) {
            maxDistance = car.getDistance();
            winners.clear();
            winners.add(car.getCarName());
        }

        if(maxDistance == car.getDistance() && !winners.contains(car.getCarName())) {
            winners.add(car.getCarName());
        }
    }

    void winnersPrint() {
        System.out.println("최종 우승자 : " + winners.toString());
    }
}
