package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {

    public static void main(String[] args) {
        String carNames;
        int count;

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.next();
        System.out.println("시도할 횟수는 몇 회인가요?");
        count = scanner.nextInt();
        System.out.println();

        Racing racing = new Racing();
        racing.startRacing(carNames, count);
    }

    public void startRacing(String input, int count) {

        String[] carNames = input.split(",");

        // 초기화
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            run(cars);
        }

        // 최종 우승자 선발
        List<Car> champions = getChampions(cars, getBestPosition(cars));

        // 챔피언 출력
        printToChampions(champions);

    }

    public void printToChampions(List<Car> champions) {
        String result = "최종우승자: ";
        for (Car champion : champions) {
            result += champion.getName();
            if (champions.lastIndexOf(champion) != champions.size() - 1) {
                result += ", ";
            }
        }
        System.out.println(result);
    }

    private List<Car> getChampions(List<Car> cars, int bestPosition) {
        return cars.stream()
                .filter(o -> o.getPosition() == bestPosition)
                .collect(Collectors.toList());
    }

    private int getBestPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);
    }

    public void run(List<Car> cars) {
        for (Car car : cars) {
            car.addMove(getMove());
            System.out.println(car.toString());
        }
        System.out.println();
    }

    private int getMove() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
