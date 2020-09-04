package mission1.step4.controller;

import mission1.step4.CarRace;
import mission1.step4.algorithm.MoveByRandomValue;
import mission1.step4.domain.car.Car;
import mission1.step4.domain.car.CarEntry;

import java.util.Arrays;
import java.util.Scanner;

public class CarRaceController {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameList = scanner.next();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int execNumber = scanner.nextInt();
        // 레이스 생성
        CarRace carRace = CarRace.getInstance(execNumber);
        // 자동차 등록
        Arrays.asList(carNameList.split(","))
                    .forEach((carName) -> carRace.join(Car.create(carName, new MoveByRandomValue())));
        System.out.println("실행결과");
        //경기 시작
        carRace.start();
    }
}


