package step4.view;


import step4.model.Car;
import step4.model.CarRacingConstant;
import step4.model.Cars;
import step4.model.Winners;

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
    
    public static void printCarRacing(Cars cars){
        for(Car car : cars.cars()){
            System.out.println(car.toString());
        }
        System.out.println();
    }


    public static void printWinners(Winners winners){
        System.out.print(String.join(CarRacingConstant.COMMA, winners.winnerNames()));
        System.out.print(CarRacingConstant.WIN);
    }

}
