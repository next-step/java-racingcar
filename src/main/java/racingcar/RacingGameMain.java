package racingcar;

import java.util.*;

public class RacingGameMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = scanner.nextLine();
        String[] carNameArr = carName.split(", ");

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNameArr.length; i++) {
            Car car = new Car(carNameArr[i]);
            carList.add(car);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            playRacing(random, carList);
            System.out.println();
        }

        int maxPosition = getMaxPosition(carList);

        List<Car> winners = getWinners(carList, maxPosition);

        StringBuilder winnerString = new StringBuilder();
        for (Car winner : winners) {
            winnerString.append(winner.getCarName()).append(", ");
        }

        System.out.println("최종 우승자 : " + winnerString.substring(0, winnerString.length() - 2));
    }

    public static void playRacing(Random random, List<Car> carList) {
        for (Car car : carList) {
            int movableNum = random.nextInt(10);

            car.move(movableNum);
            System.out.println(car.getCarName() + " : " + car.getMoveRegex());
        }
    }

    public static int getMaxPosition(List<Car> carList) {
        int maxPosition = 0;

        for (int i = 0; i < carList.size(); i++) {
            if (maxPosition < carList.get(i).getPosition()) {
                maxPosition = carList.get(i).getPosition();
            }
        }
        return maxPosition;
    }

    public static List<Car> getWinners(List<Car> carList, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() == maxPosition) {
                winners.add(carList.get(i));
            }
        }
        return winners;
    }
}
