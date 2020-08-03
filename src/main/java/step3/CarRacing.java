package step3;

import java.util.Random;
import java.util.Scanner;

public class CarRacing {

    public static void main(String[] args) {
        InputView.show();
        int numberOfCars = InputView.cars;
        int numberOfTries = InputView.tries;

        CarRacing.doRacing(numberOfCars,numberOfTries);

        ResultView.show();
    }

   static void doRacing(final int cars,final int tries){
        int[] carsRecord = new int[cars];

        Random random = new Random();
        for(int i=0;i< tries;i++) {
            for(int j=0; j< cars; j++){
                int temp = random.nextInt(10);


                System.out.println(j);
            }
        j}
   }

}

class InputView{
    static int cars;
    static int tries;

    static void show() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        cars = sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        tries = sc.nextInt();
    }


}

class ResultView{
    static void show(){
        System.out.println("실행 결과");

    }
}


