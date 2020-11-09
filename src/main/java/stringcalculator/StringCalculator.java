package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    List<String> numbers = new ArrayList<>();
    List<String> symbol = new ArrayList<>();
    //사칙연산 기호가 아닌 경우 illegalArgumentException
    public int calculator(String value){
        int count = 0;
        int result = 0;
        String[] stringInput = value.split(" ");
        boolean isSort = sortByNumAndSymbol(stringInput);
        if(isSort == true){
            count = 0;
            for(String sym : symbol){
                int num1 = 0;
                int num2 = 0;
                if(count == 0){
                    num1 = Integer.parseInt(numbers.get(0));
                    num2 = Integer.parseInt(numbers.get(count+1));
                    result = symbolSelector(num1, num2, sym);
                    count ++;
                }else{
                    num1 = result;
                    num2 = Integer.parseInt(numbers.get(count+1));
                    result = symbolSelector(num1, num2, sym);
                    count ++;
                }
                if(count > numbers.size()){
                    break;
                }
            }
        }
        System.out.println(result);
        return result;

    }

    public boolean sortByNumAndSymbol(String[] stringInput){
        boolean result = false;

        for(String str : stringInput){
            char temp = str.charAt(0);
            if(Character.isDigit(temp)){
                numbers.add(str);
            }else{
                symbol.add(str);
            }
            result = true;
        }

        return result;

    }

    public int symbolSelector(int num1, int num2, String symbol){
        int calResult = 0;
        switch(symbol){
            case "+":
                calResult = add(num1, num2);
                break;
            case "-":
                calResult = sub(num1, num2);
                break;
            case "*":
                calResult = multiple(num1, num2);
                break;
            case "/":
                calResult = div(num1, num2);
                break;
            default:
                throw new IllegalArgumentException("Incorrect symbol, Please check your symbol");
        }

        return calResult;
    }

    public int add(int num1, int num2){
        return num1+num2;
    }

    public int sub(int num1, int num2){
        return num1-num2;
    }

    public int multiple(int num1, int num2){
        return num1*num2;
    }

    public int div(int num1, int num2){
        return num1/num2;
    }

}