package step3.output;

import step3.Car;

import java.util.List;

 public class ResultView {
    public static final String MARK = "-";

    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            printOneRace(car);
            System.out.println();
        }
        System.out.println();
    }

     private static void printOneRace(Car car) {
         System.out.print(car.getName() + ": ");
         for(int j = 0; j< car.getGoCount(); j++){
             System.out.print(MARK);
         }
     }

     public static void printWinner(List<Car> winners){
         for(int i=0; i< winners.size(); i++){
             addComma(i);
             System.out.print(winners.get(i).getName());
         }
         System.out.print("가 우승했습니다.");
     }

     private static void addComma(int i) {
         if(i > 0){
             System.out.print(", ");
         }
     }
}
