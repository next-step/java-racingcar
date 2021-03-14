package step4;


public class OutputView {

    static void enterNamesOfCars(){
        System.out.println(CarRacingConstant.ENTER_NAMES_OF_CARS);
    }

    static void enterNumberOfRounds(){
        System.out.println(CarRacingConstant.ENTER_NUMBER_OF_ROUNDS);
    }

    static void printExecutionResults(){
        System.out.println(CarRacingConstant.EXECUTION_RESULTS);
    }

    static void printDash(){
        System.out.print(CarRacingConstant.DASH);
    }

    static void printCarRacing(Cars cars){
        for(int i = 0; i < cars.getNumberOfCars(); i++){
            System.out.print(cars.getCar(i).getName());
            System.out.print(CarRacingConstant.COLON);
            printCarDistance(cars.getCar(i).getDistance());
            System.out.println();
        }
        System.out.println();
    }

    static void printCarDistance(int distance){
        for(int i = 0; i < distance; i++){
            printDash();
        }
    }

}
