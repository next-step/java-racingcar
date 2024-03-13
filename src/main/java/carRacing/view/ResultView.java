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
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < car.positionOfRacingCar(); i++) {
            result.append("-");
        }
        System.out.println(result);
    }
}
