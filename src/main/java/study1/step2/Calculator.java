package study1.step2;

public class Calculator {
    public int calculate(String input){
        Validator validator = new Validator();
        validator.validate(input);
        String[] inputList = validator.getInputList(input);

        int result = Integer.parseInt(inputList[0]);

        for(int i = 1; i < inputList.length; i++){
            result = Operation.calculate(inputList, i, result);
        }
        return result;
    }
}
