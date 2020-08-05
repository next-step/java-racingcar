package step3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CarRacing {

   static int[][] doRacing(final int numOfCars,final int numberOfTries){
        int[][] move = new int[numberOfTries+1][numOfCars];
        Random random = new Random();

        for(int i=1; i <= numberOfTries;i++) {
            for(int car=0; car < numOfCars; car++){
                int randomValue= random.nextInt(10);

                if (randomValue >= 4 ){
                    move[i][car] = move[i-1][car]+1;
                    continue;
                }
                move[i][car] = move[i-1][car];
            }
        }
        return move;
   }
}

class FotStartRacing{
    public static void main(String[] args) {
        InputView.initShow();

        int[][] result = CarRacing.doRacing(InputView.cars,InputView.tries);

        ResultView.resultShow(result);
    }
}

class InputView {
    static int cars;
    static int tries;

    static void initShow() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        cars = inputCome();

        System.out.println("시도할 회수는 몇 회 인가요?");
        tries = inputCome();

        System.out.println("\n실행 결과");
    }

    static int inputCome(){
        Scanner sc = new Scanner(System.in);
        try{
           return sc.nextInt();
        }catch (InputMismatchException e){
           e.printStackTrace();
           inputCome();
           return 0;
        }
    }
}

class ResultView {
    static void resultShow(int[][] move){
        int numOfTries = move.length;
        int numOfCars = move[0].length;

        for(int i=1; i< numOfTries; i++){
            for(int j=0; j< numOfCars;j++){
                int far = move[i][j];
                for(int k=0; k< far; k++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}


