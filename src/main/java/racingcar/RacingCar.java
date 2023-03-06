package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {

    public void racingCar() {
        String carNames;
        int tryNum;

        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = sc.nextLine();
        List<Car> carList = setCarInfo(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        tryNum = sc.nextInt();
        sc.close();

        System.out.println("실행결과");
        for (int i = 0 ; i < tryNum ; i++) {
            race(carList);
        }
        printWinner(carList);
    }

    public List<Car> setCarInfo(String carNames) {
        List<Car> carList = new ArrayList<>();
        String[] cars = carNames.split(",");

        for (String car : cars) {
            carList.add(new Car(car, 0));
        }

        return carList;
    }

    public void race(List<Car> carList) {
        for (Car car : carList) {
            car.goOrStay();
        }
        printRacingState(carList);
    }

    public void printRacingState(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> carList) {
        int maxLocation = 0;
        for (Car car : carList) {
            int nowLocation = car.getLocation();
            if (maxLocation <= nowLocation) {
                maxLocation = nowLocation;
            }
        }

        System.out.print("최종 우승자: ");
        for (Car car : carList) {
            int nowLocation = car.getLocation();
            if (maxLocation == nowLocation) {
                System.out.print(car.getName() + " ");
            }
        }
    }
}
