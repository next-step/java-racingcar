package step3;

public class OutputView {

    static void printNumberOfCars(){
        System.out.println(CarRacingConstant.NUMBER_OF_CARS);
    }

    static void printNumberOfRounds(){
        System.out.println(CarRacingConstant.NUMBER_OF_ROUNDS);
    }

    static void printExecutionResults(){
        System.out.println(CarRacingConstant.EXECUTION_RESULTS);
    }

    static void printDash(){
        System.out.print(CarRacingConstant.DASH);
    }

    static void printCarRacing(Cars cars){
        for(int i = 0; i < cars.getNumberOfCars(); i++){
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
