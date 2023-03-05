import java.util.*;

import static java.util.stream.Collectors.toList;

public class CarRace {

    public static void main(String[] args) {
        race();
    }

    public static void race() {

        // 입력
        Scanner sc = new Scanner(System.in);
        System.out.println("input names : ");
        List<Car> carList = getCarList(sc.next());
        System.out.println("rotation count : ");
        int rotation = sc.nextInt();
        sc.close();

        // 실행 결과
        System.out.println("result");
        List<String> winnerList = playGame(carList, rotation);
        System.out.println("final winner : " + winnerList.toString());
    }

    public static List<Car> getCarList(String cars) {
        String[] carNames = cars.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public static List<String> playGame(List<Car> carList, int rotation) {
        for (int i = 0; i < rotation; ++i) {
            playSingleLoop(carList);
            printRace(carList);
        }
        return getWinnersLambda(carList);
    }

    public static void playSingleLoop(List<Car> carList) {
        for (Car car : carList) {
            car.addDistance(moveForwardRandom());
        }
    }

    public static int moveForwardRandom() {
        Random random = new Random();
        int next = random.nextInt(10);
        if (next >= 4) {
            return 1;
        }
        return 0;
    }

    public static void printRace(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static List<String> getWinners(List<Car> carList) {
        carList.sort((o1, o2) -> {
            return o2.getDistance() - o1.getDistance(); // desc
        });

        List<String> winnerList = new ArrayList<>();
        int maxDistance = carList.get(0).getDistance();
        for (Car car : carList) {
            if (car.getDistance() < maxDistance) {
                break;
            }
            winnerList.add(car.getName());
        }
        return winnerList;
    }

    public static List<String> getWinnersLambda(List<Car> carList) {

        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(-1);

        return carList.stream()
                .filter(car -> car.getDistance() >= maxDistance)
                .map(Car::getName)
                .collect(toList());
    }
}
