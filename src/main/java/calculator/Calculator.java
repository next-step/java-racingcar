package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {
    final static String DELIMITER = " ";

    public enum Operation {
        ADD("+"){public int operate(int x,int y){return x+y;}},
        SUB("-"){public int operate(int x,int y){return x-y;}},
        MULTIPLY("*"){public int operate(int x,int y){return x*y;}},
        DIVIDE("/"){public int operate(int x,int y){return x/y;}};
        private final String opertaion;

        Operation(String operation){
            this.opertaion = operation;
        }

        public String getOpertaion() {
            return opertaion;
        }

        abstract int operate(int x, int y);
    }
    public void start() {
        //입력값
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산기입력 : ");
        String input = scanner.nextLine(); //"202 + 32 * 40 /
        scanner.close();

        inputValidate(input);

        String[] actuals = input.split(DELIMITER);
        Arrays.stream(actuals).forEach(actual -> {actualValidate(actual);});

        List<Integer> numsList = splitNumber(actuals);
        List<String> oprnList = splitOperation(actuals);

        var result = numsList.get(0);
        for(var i = 1; i<numsList.size(); i++){
            result = calculator(result, numsList.get(i), oprnList.get(i - 1));
        }

        System.out.println("연산결과:"+result);
    }

    private void inputValidate(String input) {
        if(input.isEmpty() || input == null){
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private void actualValidate(String actual) {
        if(!actual.matches("\\d*") && !actual.matches("[+\\-*/]")){
            throw new IllegalArgumentException("사칙연산 기호가 아닌 값이 입력되었습니다.");
        }
    }

    private List<Integer> splitNumber(String[] actuals) {
        return Arrays.stream(actuals).filter(number-> number.matches("\\d*")).map(number -> Integer.parseInt(number)).collect(Collectors.toList());
    }

    private List<String> splitOperation(String[] actuals) {
        return Arrays.stream(actuals).filter(operation-> operation.matches("[+\\-*/]")).collect(Collectors.toList());
    }

    public int calculator(int num1, int num2, String oprn) {
        var result = 0;
        for(Operation op : Operation.values()){
            if(oprn.equals(op.getOpertaion())) result = op.operate(num1,num2);
        }
        System.out.println("reslut"+result);
        return result;
    }
}
