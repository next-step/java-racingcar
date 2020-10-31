package stringCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> values = new ArrayList<>();
    static ArrayList<Character> symbols = new ArrayList<>();
    static int result;

    public static void main(String[] args) {

        getValueAndSymbol(getStringFoumula().split(" "));

        calculate();

        System.out.println("결과는 " + result + "입니다");

    }

    public static String getStringFoumula() {
        Scanner scanner = new Scanner(System.in);
        String foumula = scanner.nextLine();
        if(foumula == null || foumula.trim().isEmpty())
            throw new IllegalArgumentException("null이나 공백은 입력될 수 없습니다.");
        return foumula;
    }

    public static void getValueAndSymbol(String[] splitFoumula){
        for (int i = 0; i < splitFoumula.length; i++) {

            if(i % 2 == 0 || i == 0) {
                values.add(Integer.parseInt(splitFoumula[i]));
                continue;
            } else if(!("+-*/".contains(splitFoumula[i]))) {
                throw new IllegalArgumentException("사칙연산 기호를 제대로 입력하지 않았습니다");
            }
            symbols.add(splitFoumula[i].charAt(0));

        }
    }

    public static void calculate(){
        Calculator calculator = new Calculator();
        for (int i = 0; i < symbols.size(); i++) {
            char symbol = symbols.get(i);

            if(i == 0) result = values.get(i);

            if(symbol == '+') result = calculator.addition(result,values.get(i+1));
            if(symbol == '-') result = calculator.substract(result,values.get(i+1));
            if(symbol == '*') result = calculator.multiplication(result,values.get(i+1));
            if(symbol == '/') result = calculator.divide(result,values.get(i+1));
        }
    }


}
