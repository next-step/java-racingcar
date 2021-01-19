import racingcar.Car;
import racingcar.CarFactory;
import racingcar.CarFactoryImpl;
import racingcar.RacingCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    public static void main(String[] args){
        System.out.println("경주할 자동차 이름을 입력하세요:");
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(",");

        CarFactory carFactory = new CarFactoryImpl();
        List<Car> cars = carFactory.makeCars(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int loopCount = scanner.nextInt();
        System.out.println();
        System.out.println("실행 결과");
        for (int i=0; i<loopCount; i++){
            for (Car car : cars) {
                car.go();
                car.print();
            }
            System.out.println();
        }

        List<String> winners = new ArrayList<>();

        cars.sort(Comparator.comparingInt(Car::getPosition));
        int maxScore = cars.get(0).getPosition();
        for (Car car : cars) {
            if (maxScore == car.getPosition()) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자: " + winners);
   }
}