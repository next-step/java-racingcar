package racingcar;

import java.util.*;

public class RacingGame {
    public static void race(List<Car> carList, int rotation) {

        System.out.println("result : ");
        for (int i = 0; i < rotation; ++i) {
            // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
            for (Car car : carList) {
                car.move(pickRandom());
            }
            // 경기모양 출력
            printRace(carList);
        }

        //우승자 출력
        showWinner(carList);

    }

    final static int CAR_MOVE_CONDITION = 4;
    public static int pickRandom() {
        Random random = new Random();
        int next = random.nextInt(10);
        if (next >= CAR_MOVE_CONDITION) {
            return 1;
        }
        return 0;
    }

    public static void printRace(List<Car> carList) {
        for (Car car : carList) {
            String printStreet = "-";
            String printStreet2 = printStreet.repeat(car.getPosition());
            System.out.println(car.getName() + " : " + printStreet2);
        }
        System.out.println("");
    }

    public static void showWinner(List<Car> carList){

        //Collections.sort(list, Collections.reverseOrder());
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getPosition() - o1.getPosition(); // desc
            }
        });

        //order desc
        for (Car car : carList) {
            System.out.println(" carList : " + car.getName() + ", " + car.getPosition());
        }

        List<String> winnerList = new ArrayList<>();
        int maxDistance = carList.get(0).getPosition();
        for (Car car : carList) {
            if (car.getPosition() < maxDistance) {
                break;
            }
            winnerList.add(car.getName());
        }

        System.out.println("final winner : " + winnerList.toString());
    }
}
