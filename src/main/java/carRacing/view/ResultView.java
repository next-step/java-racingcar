package carRacing.view;

import carRacing.model.RacingCar;

import java.util.List;

public class ResultView {

    public static void printRacingResult(){
        System.out.println("실행 결과");
    }

    public static void printRacing(List<RacingCar> records){
        for (RacingCar racingCar: records) {
            printPlayCar(racingCar);
        }
        System.out.println();
    }

    private static void printPlayCar(RacingCar car){

        System.out.println("-".repeat(Math.max(0, car.positionOfRacingCar())));
    }

    public static void printRacingCarName(List<RacingCar> records){
        for (RacingCar racingCar: records) {
            printPlayCarName(racingCar);
        }
        System.out.println();
    }

    private static void printPlayCarName(RacingCar car){

        System.out.println(car.NameOfCar() + " : " + "-"
                .repeat(Math.max(0, car.positionOfRacingCar())));
    }

    public static void WinnerOfRacing(List<String> name){
        String result = String.join(",", name);

        System.out.println(result + " 이/가 최종 우승했습니다.");
    }
}
