package racing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {
     public static void main(String[] args) {

        CarRace carRace = new CarRace();
        List<String> carList = carRace.getRacingJoinList(); // 자동차 경주 참가자 명단 입력
        Car[] carArr = new Car[carList.size()];

        // 입력된 이름 수 만큼 Car 객체 생성
        for(int i=0; i < carList.size(); i++) {
            carArr[i] = new Car();
            carArr[i].setCarName(carList.get(i));
        }

        carRace.getTrackCount();    // 경주할 트랙수 입력

        // 레이싱 경기 시작
        for(int i=0; i < carRace.trackCount; i++) {
            System.out.println(i+1 + "트랙 결과");
            carRace.runningRace(carArr);
            System.out.println();
        }

        // 최종 우승자 발표
        carRace.winnersPrint();
    }
}
