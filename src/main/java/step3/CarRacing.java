package step3;

import java.util.Random;
import java.util.Scanner;

class FotStartRacing{
    public static void main(String[] args) {
        InputView.initShow();

        int numberOfCars = InputView.cars;
        int numberOfTries = InputView.tries;

        CarRacing.doRacing(numberOfCars,numberOfTries);
    }
}

public class CarRacing {

   static void doRacing(final int cars,final int tries){
        int[] carMove = new int[cars];
        StringBuilder[] carMove2= new StringBuilder[cars];

        for(int i= 0; i< carMove2.length;i++){
            carMove2[i] = new StringBuilder("0");
        }

        Random random = new Random();
        for(int i=0;i< tries;i++) {
            for(int j=0; j< cars; j++){
                int randomValue= random.nextInt(10);

                carMove2[j].append(0);
//                System.out.println(carMove2[j].toString());
                if (randomValue >= 4 ){
                    int endChar = carMove2[j].length()-1;
                    char s = carMove2[j].charAt(endChar);

                    int temp = Integer.valueOf(s-'0');
                    int move= temp+1;


                    carMove2[j].replace(endChar-1,endChar,String.valueOf(move));
                    System.out.println(carMove2[j].toString());

//                    carMove[j]++;
                }
            }
//            ResultView.show(carMove);

        }
   }

}

class InputView{
    static int cars;
    static int tries;

    static void initShow() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        cars = sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        tries = sc.nextInt();

        System.out.println("\n실행 결과");
    }
}

class ResultView{
    static void show(int[] move){
        for(int distance : move){
            for(int i=0; i< distance;i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}


