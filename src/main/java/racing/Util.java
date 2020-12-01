package racing;

import java.util.Random;
import java.util.Scanner;

public class Util {

    public int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        String strNumber = scanner.nextLine();
        return toInt(strNumber);
    }
    public int toInt(String strNumber){
        return Integer.parseInt(strNumber);
    }

    public int getRandomNumber(){
        int moveableNumber = 4;
        int number = new Random().nextInt(10);
        if(number < moveableNumber) {
            return 0;
        }
        return number;
    }
}
