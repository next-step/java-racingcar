package step2.model;

public class Operator {

    CalculatorComponents calculatorComponents = new CalculatorComponents();

    public Integer calculator(String input) {
        String[] inputSplit = input.split(" ");
        int result = Integer.parseInt(inputSplit[0]);
        for(int index = 1; index < inputSplit.length; index += 2){
            if (inputSplit[index].equals("+") ) {
                result += Integer.parseInt(inputSplit[index + 1]);
            } else if (inputSplit[index].equals("-") ) {
                result -= Integer.parseInt(inputSplit[index + 1]);
            } else if (inputSplit[index].equals("*")){
                result *= Integer.parseInt(inputSplit[index + 1]);
            } else if (inputSplit[index].equals("/")) {
                result /= Integer.parseInt(inputSplit[index + 1]);
            }
        }
        return result;
    }

}
