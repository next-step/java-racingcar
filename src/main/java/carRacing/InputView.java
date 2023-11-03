package carRacing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static int readCarCount(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return isPositive(isNumber());
    }

    public static int readRaceCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return isPositive(isNumber());
    }

    private static int isNumber(){

        try{
            return SCANNER.nextInt();
        }catch (InputMismatchException error){
            throw new InputMismatchException("정수를 입력해 주세요");
        }
    }

    private static int isPositive(int number){

        if(number<0){
            throw new InputMismatchException("양수를 입력해 주세요.");
        }
        return number;
    }





}
