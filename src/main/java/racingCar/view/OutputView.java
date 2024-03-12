package racingCar.view;

import racingCar.RacingCar;

import java.util.List;

public class OutputView {

    private static final String HYPHEN = "-";
    private static final String NEW_LINE = "\n";

    public static void printRacingResult(){
        System.out.println(NEW_LINE + "실행 결과");
    }

    public static void printRacing(List<RacingCar> records){
        for (RacingCar racingCar: records) {
            printOneCar(racingCar);
        }
        System.out.println();
    }

    private static void printOneCar(RacingCar car){
        String result = "";
        for(int i=0; i<car.positionOfRacingCar(); i++) {
            result += HYPHEN;
        }
        System.out.println(result);
    }

}

