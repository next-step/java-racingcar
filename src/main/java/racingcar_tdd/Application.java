package racingcar_tdd;

import racingcar_tdd.domain.Car;
import racingcar_tdd.domain.Cars;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carnamelist = Arrays.asList(input.next().split(","));

        System.out.println("시도할 횟수는 몇 회인가요?");
        int track = input.nextInt();

        var racing_cars = makeCar(carnamelist);
        var winers = racing(racing_cars, track);

        System.out.println("최종우승자: " +
                String.join(
                        ", ",
                        winers.stream().map(Car::getName).collect(Collectors.toList())
                )
        );
    }

    private static List<Car> racing(Cars carnamelist, int track) {

        System.out.println("실행결과");
        for (int i = 0; i < track; i++){
            for (Car car :carnamelist.toList()) {
                car.move();
            }
            carnamelist.printRace();
            System.out.println("");
        }

        final int maxinumPosition = carnamelist.getMaximumPosition();
        return carnamelist.getWinners(maxinumPosition);
    }

    private static Cars makeCar(List<String> carnamelist){
        List<Car> cars = new ArrayList<>();

        for (String car : carnamelist) {
            cars.add(new Car(car));
        }

        Cars racing_cars = new Cars(cars);
        return racing_cars;
    }
}
