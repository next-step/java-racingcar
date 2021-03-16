package step3.view;

import step3.domain.Cars;

public class ResultView {
    public static void printResult(Cars cars, int iter) {
        printResult(iter);
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.println(cars.getCars().get(i).getRacingLog());
        }
        System.out.println();
    }

    public static void printResult(int iter) {
        if (iter == 0) {
            System.out.println("실행 결과");
        }
    }
}
