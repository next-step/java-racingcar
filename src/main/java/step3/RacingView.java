package step3;

import java.util.List;

public class RacingView {
    private static final String TIREMARK = "-";

    public RacingView() {
        System.out.println("\n실행 결과");
    }

    public static void print(List<RacingCar> racingCar) {
        for(RacingCar car : racingCar) {
            for(int i=0; i<car.getCurrentPosition(); i++) {
                System.out.print(TIREMARK);
            }
            System.out.println(" ");
        }
        System.out.println("");
    }
}