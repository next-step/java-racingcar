package service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import car.Car;

import static java.util.Arrays.asList;

public class RacingCarService {

    // 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    // 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
    // 자동차 이름은 쉼표(,)를 기준으로 구분한다.
    // 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    // 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    // 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
    // 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scan = new Scanner(System.in);
        String carNames = scan.nextLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        scan = new Scanner(System.in);
        int distance = Integer.parseInt(scan.nextLine());


        List<Car> cars = Arrays.asList(carNames.split(",")).stream()
                .map( name -> new Car(name, distance))
                .collect(Collectors.toList());

        System.out.println(cars);

    }


}
