package step4.view;


import step4.model.CarRacingConstant;
import step4.model.Cars;

public class OutputView {

    public static void enterNamesOfCars(){
        System.out.println(CarRacingConstant.ENTER_NAMES_OF_CARS);
    }

    public static void enterNumberOfRounds(){
        System.out.println(CarRacingConstant.ENTER_NUMBER_OF_ROUNDS);
    }

    public static void printExecutionResults(){
        System.out.println();
        System.out.println(CarRacingConstant.EXECUTION_RESULTS);
    }

    public static void printDash(){
        System.out.print(CarRacingConstant.DASH);
    }

    public static void printCarRacing(Cars cars){
        for(int i = 0; i < cars.getNumberOfCars(); i++){
            System.out.print(cars.getCar(i).getName());
            System.out.print(CarRacingConstant.COLON);
            printCarDistance(cars.getCar(i).getDistance());
            System.out.println();
        }
        System.out.println();
    }

    public static void printCarDistance(int distance){
        for(int i = 0; i < distance; i++){
            printDash();
        }
    }

    public static void printWinners(String[] winners){
        String winnerList = String.join(CarRacingConstant.COMMA_BLANK, winners);
        System.out.print(winnerList);
        System.out.print(CarRacingConstant.WIN);
    }

}
