package step1;

import java.util.LinkedList;


public class StringCalculator {

    int excuteCalculation(String input) {
        LinkedList<Integer> numberList = new LinkedList <>();
        LinkedList<Character> operatorList = new LinkedList <>();

        Utils.stringEmptyValidation(input);
        numberSymbolExtract(input, numberList, operatorList);
        calculationLoop(numberList, operatorList);

        return numberList.poll();
    }

    void numberSymbolExtract(String input, LinkedList<Integer> numberList, LinkedList<Character> operatorList) {
        int charNumber;
        int inputLenth = input.length();
        for (int i = 0; i < inputLenth; i++) {
            char charat = input.charAt(i);
            if (Utils.isNumber(charat)) {
                charNumber = Character.getNumericValue(charat);
                numberList.add(charNumber);
                continue;
            }
            Utils.isOperator(charat);
            operatorList.add(charat);
        }
    }

    void calculationLoop(LinkedList<Integer> numberList, LinkedList<Character> operatorList){
        while (!operatorList.isEmpty()) {
            int prevNumber = numberList.poll();
            int nextNumber = numberList.poll();
            char charat = operatorList.poll();
            switch (charat) {
                case '+':
                    numberList.addFirst(Calculator.addition(prevNumber, nextNumber));
                    break;
                case '-':
                    numberList.addFirst(Calculator.subtraction(prevNumber, nextNumber));
                    break;
                case '*':
                    numberList.addFirst(Calculator.multiplication(prevNumber, nextNumber));
                    break;
                default:
                    numberList.addFirst(Calculator.division(prevNumber, nextNumber));
            }
        }
    }


}
