package step3.view;

import step3.domain.RacingCar;

import java.util.List;

public class RacingOutput {
    private static final String TIRE_MARK = "-";

    public RacingOutput() {
        System.out.println("\n실행 결과");
    }

    public static void printRacing(List<RacingCar> racingCar) {
        for(RacingCar car : racingCar) {
            System.out.print(car.getCarName() + " : ");
            for(int i=0; i<car.getCurrentPosition(); i++) {
                System.out.print(TIRE_MARK);
            }
            System.out.println(" ");
        }
        System.out.println("");
    }

    public static void printWinner(List<String> winnerNames) {
        StringBuilder sb = new StringBuilder();
        for(String name : winnerNames) {
            sb.append(name).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));

        System.out.println(sb + "가 최종 우승했습니다.");
    }
}