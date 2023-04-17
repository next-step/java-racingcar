package study;

import java.util.Arrays;
import java.util.Random;

public class CarRacing {

    public static void main(String[] args) {

        inputView.inputView();
        racing(inputView.value, inputView.number);

    }

    public static void racing(String value, int number) {

        int[] carNumber = new int[Integer.parseInt(value)];

        for(int i=0; i<number; i++){
            carMoving(carNumber);
            System.out.println(Arrays.toString(carNumber));
            resultView.resultView(carNumber);
            System.out.println("\n");
        }
    }

    private static void carMoving(int[] carNumber) {
        for(int j=0; j < carNumber.length; j++){
            carNumber[j]+=randomMaking();
        }
    }

    private static int randomMaking() {
        Random random = new Random();
        int carRamdom = random.nextInt(10);
         if(carRamdom >= 4){
            return 1;
         }
         return 0;
    }
}

