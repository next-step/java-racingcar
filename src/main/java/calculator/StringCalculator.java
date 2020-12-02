package calculator;

import java.util.LinkedList;
import java.util.Scanner;

public class StringCalculator {

    public int calculateInfo(String input){
        String inputValue = input.replaceAll(" ", "");
        char[] arrCh = inputValue.toCharArray();
        int result = 0;
        result = calculateDetail(arrCh);
        return result;
    }

    public int calculateDetail(char[] inputValue){
        LinkedList<Integer> numList = new LinkedList<Integer>();
        LinkedList<Character> opList = new LinkedList<Character>();
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
            if(op == '+') numList.addFirst(prevNum + nextNum);
            if(op == '-') numList.addFirst(prevNum - nextNum);
            if(op == '*') numList.addFirst(prevNum * nextNum);
            if(op == '/') numList.addFirst(prevNum / nextNum);
        }
    }

    private void distinguishValue(char[] inputValue, LinkedList<Integer> numList, LinkedList<Character> opList) {
        for(int i = 0; i < inputValue.length; i++) {
            char ch = inputValue[i];
            if(ch != '+' && ch != '-' && ch != '/' && ch != '*') {
                numList.add(Integer.parseInt(Character.toString(ch)));
            }
            if(ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                opList.add(ch);
            }
        }
    }

    public static void main(String[] args){
        System.out.println("사칙연산을 수행할 식을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringCalculator cal = new StringCalculator();
        int result = cal.calculateInfo(input);
        System.out.println(result);
    }
}
