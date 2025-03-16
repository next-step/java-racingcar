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

        for (int i = 0; i < positionStrings.size(); i++) {
            System.out.print("Car" + (i + 1) + ": ");
            System.out.println(positionStrings.get(i));
        }
        System.out.println();
    }
}
