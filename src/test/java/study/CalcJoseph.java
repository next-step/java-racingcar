package study;

public class CalcJoseph {

    public void calculateFinal(String input ){
        String[] arrays = input.split( " ");
        float result  = Float.parseFloat(arrays[0]);

        for (int i = 1; i < arrays.length; i += 2) {
            result = calculate(result, arrays[i], Float.parseFloat(arrays[i+1]));
        }
            System.out.println("result : " + result);
    }
    float calculate(float num1, String operator,  float num2){
        switch (operator){
            case "+":
                return add(num1, num2);
            case "-":
                return this.subtraction(num1, num2);
            case "*":
                return this.multiply(num1, num2);
            case "/":
                return this.divide(num1, num2);
            default:
                throw new IllegalArgumentException("유효하지 않은 연산입니다. operator : " + operator);
        }
    }

    float add(float a, float b ){
        return a + b;
    }

    float subtraction(float a, float b){
        return a - b;
    }

    float multiply(float a, float b){
        return a * b;
    }

    float divide(float a, float b){
        return a/b;
    }
}
