package calculatorFunction;

import java.util.List;
import java.util.ArrayList;

public class Calculator {
    public static void execute(){
        System.out.println("수식을 입력하시오: ");
        String str = GetInput.inputString();
        if (str.length()==0) {
            throw new IllegalArgumentException("Error: need right expression");
        }
        ArrayList<String> stringArray = GetInput.parsing(str);
        Calculator.returnCalculatedValue(stringArray);
    }

    public static void returnCalculatedValue(List<String> stringArray){
        for(int i = 0; i < (stringArray.size() + 1) / 2; i++){
            if (determineCalculatedValueValid(stringArray, i)) {
                return;
            }
            parseOperation(stringArray,i * 2);
        }
    }

    public static boolean determineCalculatedValueValid(List<String> stringArray, int i) {
        if (stringArray.get(0).equals("ERROR")) {
            System.out.println("ERROR");
            System.out.println("종료합니다.");
            return true;
        }
        if (i * 2 == stringArray.size() - 1) {
            System.out.println("정답: " + Double.parseDouble(stringArray.get(stringArray.size() - 1)));
            return true;
        }

        return false;
    }

    public static void parseOperation(List<String> stringArray, int start){
        double firstOperand, secondOperand;

        if (stringArray.get(start).equals("ERROR") || stringArray.get(start + 2).equals("ERROR")) {
            stringArray.set(0, "ERROR");
            return;
        }

        String operator=stringArray.get(start + 1);
        firstOperand=Double.parseDouble(stringArray.get(start));
        secondOperand=Double.parseDouble(stringArray.get(start + 2));

        double result=0;
        if(operator.equals("+")){
            result=add(firstOperand,secondOperand);
        }
        else if(operator.equals("-")){
            result=sub(firstOperand,secondOperand);
        }
        else if(operator.equals("*")){
            result=mul(firstOperand,secondOperand);
        }
        else if(operator.equals("/")){
            if(secondOperand==0) {
                stringArray.set(0, "ERROR");
            }
            else {
                result = div(firstOperand, secondOperand);
            }
        }
        else {
            throw new IllegalArgumentException("Error: need right operator");
        }

        stringArray.set(start + 2, String.valueOf(result));
    }

    public static double add(double firstOperand, double secondOperand) {

        return firstOperand + secondOperand;
    }
    public static double sub(double firstOperand, double secondOperand){

        return firstOperand - secondOperand;
    }
    public static double mul(double firstOperand, double secondOperand) {

        return firstOperand * secondOperand;
    }
    public static double div(double firstOperand, double secondOperand) {

        return firstOperand / secondOperand;
    }
}
