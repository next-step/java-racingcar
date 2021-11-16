package step2;

import java.util.*;

public class StringCalculator {
    private static Map<String, Operator> operators = new HashMap<>();

    static {
        for (Operator value : Operator.values())
            operators.put(value.operator, value);
    }

    public void validate(String input) {
        if (input.equals("") || input.equals(" ") || input == null) throw new IllegalArgumentException();
        List<String> inputList = Arrays.asList(input.split(" "));
        for (String opCheck : inputList) {
            isValid(opCheck);
        }
    }

    public void isValid(String opCheck) {
        if (!(opCheck.matches("\\d+") || opCheck.matches("[\\+*\\/-]"))) throw new IllegalArgumentException();
    }

    public int calculateInfo(String input){
        validate(input);
        String inputValue = input.replaceAll(" ", "");//공백을 삭제처리
        char[] arrCh = inputValue.toCharArray();

        return calculateDetail(arrCh);

        int result = 0;
        result = calculateDetail(arrCh);
        return result;

    }

    public int calculateDetail(char[] inputValue){
        LinkedList<Integer> numList = new LinkedList<Integer>();
        LinkedList<Character> opList = new LinkedList<Character>();

        distinguishValue(inputValue, numList, opList);
        calculateExecute(opList, numList);
        return numList.poll();

        int value = 0;
        distinguishValue(inputValue, numList, opList);
        calculateExecute(opList, numList);
        value = numList.poll();
        return value;

    }

    private void calculateExecute(LinkedList<Character> opList, LinkedList<Integer> numList) {
        while(!opList.isEmpty()){
            int prevNum = numList.poll();
            int nextNum = numList.poll();
            char op = opList.poll();
            processOperator(op, prevNum, nextNum, numList);
        }
    }

    private void processOperator(char op, int preNum, int nextNum, LinkedList<Integer> numList) {
        numList.addFirst(operators.get(Character.toString(op)).calculate(preNum, nextNum));
    }

    private void distinguishValue(char[] inputValue, LinkedList<Integer> numList, LinkedList<Character> opList) {

        for (char Ivalue : inputValue) {
            char ch = Ivalue;

        for (int i = 0; i < inputValue.length; i++) {
            char ch = inputValue[i];

            processValues(ch, numList, opList);
        }
    }

    private void processValues(char ch, LinkedList<Integer> numList, LinkedList<Character> opList) {
        if (ch != '+' && ch != '-' && ch != '/' && ch != '*') {
            numList.add(Integer.parseInt(Character.toString(ch)));
        }
        if(ch == '+' || ch == '-' || ch == '/' || ch == '*') {
            opList.add(ch);
        }
    }
}
