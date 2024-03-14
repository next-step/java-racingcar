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
        for (int i = 0; i < car.positionOfRacingCar(); i++) {
            result += HYPHEN;
        }
        System.out.println(result);
    }


    public static void printRacingWithName(List<RacingCar> records){
        for (RacingCar racingCar: records) {
            printOneCarWithName(racingCar);
        }
        System.out.println();
    }

    private static void printOneCarWithName(RacingCar car){
        String result = car.NameOfCar() + " : ";
        for (int i = 0; i < car.positionOfRacingCar(); i++) {
            result += HYPHEN;
        }
        System.out.println(result);
    }

    public static void WinnerOfRacing(List<String> name){
        String result = String.join(",", name);

        System.out.println(result + "가 최종 우승했습니다.");
    }

}
