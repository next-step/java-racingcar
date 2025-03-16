package racing;

import java.util.List;

public class ResultView {

    public static void printTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printTryCount(int tryCount) {
        System.out.println(tryCount + "회 시도 결과");
    }

    public static void printCars(Cars cars) {
        List<String> positionStrings = cars.getPositionStrings();
        List<CarName> carNames = cars.getCarNames();

        for (int i = 0; i < positionStrings.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            System.out.println(positionStrings.get(i));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("가 최종 우승했습니다.");
        System.out.println();
    }
}
