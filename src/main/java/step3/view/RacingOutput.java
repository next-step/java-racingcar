package step3.view;

import step3.domain.RacingCar;

import java.util.List;

public class RacingOutput {
    private static final String TIRE_MARK = "-";
    private static final String NAME_SEPARATOR = " : ";
    private static final String START_NOTICE = "실행 결과";

    private RacingOutput() {
        throw new AssertionError();
    }

    public static void printRacing(List<RacingCar> racingCar) {

        System.out.println("");
        System.out.println(START_NOTICE);
        for(RacingCar car : racingCar) {
            System.out.print(car.getCarName() + NAME_SEPARATOR);
            for(int i=0; i<car.getCurrentPosition(); i++) {
                System.out.print(TIRE_MARK);
            }
            System.out.println(" ");
        }
        System.out.println("");
    }

    public static void printWinner(List<RacingCar> winnerNames) {

        StringBuilder sb = new StringBuilder();

        for(RacingCar car : winnerNames) {
            sb.append(car.getCarName()).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));

        System.out.println(sb + "가 최종 우승했습니다.");
    }
}