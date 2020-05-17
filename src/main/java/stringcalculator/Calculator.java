package stringcalculator;

public class Calculator {

    private String inputExpression;

    //  연산식으로 만들기
    public double trimInputExpression(String targetExpression){
        //  일단
        String trimmedExpression = targetExpression.replace(" ", "");
        String operands[] = trimmedExpression.replaceAll("[^0-9]","").split("");  //  연산자 리스트
        String operators[] = trimmedExpression.replaceAll("[0-9]", "").split("");       //  피연산자 리스트

        //  계산
        return calculate(operators, operands);
    }


    //  람다식으로 만들어서 리스트에서 뽑아서 계산
    //  고려 해야할 점 double로 만들기?

    public double calculate(String[] operators, String[] operands){
        double result = Double.parseDouble(operands[0]);

        for(int i=0; i< operators.length; i++){
            switch (operators[i]){
                case "+":
                    result += Double.parseDouble(operands[i+1]);
                    break;
                case "-":
                    result -= Double.parseDouble(operands[i+1]);
                    break;
                case "*":
                    result *= Double.parseDouble(operands[i+1]);
                    break;
                case "/":
                    result /= Double.parseDouble(operands[i+1]);
                default:
                    break;
            }
        }

        return result;
    }

    public boolean isNotValidOperator(String inputExpression){
        String trimmedExpression = inputExpression.replace(" ", "").replaceAll("[0-9]", "");
        String operators = "+-*/";
        for(int i=0; i< trimmedExpression.length(); i++){
            if(!operators.contains(trimmedExpression.substring(i, i+1))){
                throw new IllegalArgumentException("잘못된 연산자 기호: "+ trimmedExpression.substring(i, i+1));
            }
        }

        return true;
    }

}
