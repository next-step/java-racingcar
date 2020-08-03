package step2_2;

import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
 //       String input= "12 + 3 * 4 / 7";

        StringCalculator.isBlack(input);
        StringCalculator.isFourOperations(input);

        StringCalculator calculator = new StringCalculator();
        int result = calculator.doCalculate(input);
        System.out.println("result is :"+result);
    }

    static void isBlack(String input) throws IllegalArgumentException{
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
    }
    static void isFourOperations(String input) throws IllegalArgumentException{
        String[] inputs = input.split(" ");
        for(String s :inputs){
            if(s.equals("+") || s.equals("-") || s.equals("*") ||s.equals("/")){
               continue;
            }else if(Integer.MAX_VALUE >= Integer.parseInt(s)){
               continue;
            }else{
                throw new IllegalArgumentException();
            }
        }
    }


    int doCalculate(String input){

        String inputs[] = input.split(" ");
        int result = Integer.parseInt(inputs[0]);

        for (int i =0; i< inputs.length;i++){
            if(inputs[i].equals("+")){
                result = plus(result,Integer.parseInt(inputs[i+1]));
            }else if(inputs[i].equals("-")) {
                result = minus(result,Integer.parseInt(inputs[i+1]));
            }else if(inputs[i].equals("*")) {
                result = multiple(result,Integer.parseInt(inputs[i+1]));
            }else if(inputs[i].equals("/")) {
                result = divide(result,Integer.parseInt(inputs[i+1]));
            }
        }
        return result;
    }

    int plus(int a, int b) {
       return a+b;
    }
    int minus(int a, int b){
        return a-b;
    }
    int multiple(int a, int b){
        return a*b;
    }
    int divide(int a, int b){
        return a/b;
    }
}

