package racing.view;

import racing.domain.Car;

import java.util.List;

public final class Output {
    private Output() {
    }

    public static void win(List<String> winnerList) {
        System.out.print("\n" + "최종 우승자: ");
        System.out.println(String.join(", ", winnerList));
    }

    public static void printCarDistance(List<Car> cars) {
        System.out.println();
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i).getName() + " : ");
            printCarDistance(cars.get(i).getMoveCount());
            System.out.println();
        }
    }

    private static void printCarDistance(int count) {
        for (int j = 0; j < count; j++) {
            System.out.print("-");
        }
    }
}
