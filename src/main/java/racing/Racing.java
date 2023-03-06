package racing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {
    public static void main(String[] args) {

        CarRace carRace = new CarRace();
        ArrayList<Car> cars = new ArrayList<>();
        List<String> getCars = carRace.getRacingJoinList(); // 자동차 경주 참가자 명단 입력

        // 입력된 이름 수 만큼 Car 객체 생성
        for (int i = 0; i < getCars.size(); i++) {
            cars.add(new Car(getCars.get(i)));
        }

        // 경주할 트랙수 입력
        carRace.getTrackCount();

        // 레이싱 경기 시작
        for (int i = 0; i < carRace.getTotalTrackCount(); i++) {
            System.out.println(i + 1 + "트랙 결과");
            carRace.runningRace(cars);
            System.out.println();
        }

        // 최종 우승자 발표
        carRace.winnersPrint();
    }
}
