package step2;

public class StringCalculator {

    public int calculate(String data) {
        checkInputValidation(data);

        String[] splitData = data.split(" ");

        int result = checkNumberValue(splitData[0]);
        for(int i = 1; i < splitData.length; i+=2) {
            result = getResult(result, splitData[i], checkNumberValue(splitData[i+1]));
        }

        return result;
    }

    private int getResult(int first, String operator, int second) {
        switch (operator) {
            case "+":
                return plus(first, second);
            case "-":
                return minus(first, second);
            case "*":
                return multiple(first, second);
            case "/":
                return divide(first, second);
            default:
                throw new IllegalArgumentException("+,-,*,/ 중 연산자를 입력해주세요");
        }
    }


    private int checkNumberValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ignored) {
            throw new IllegalArgumentException("연산대상이 숫자가 아닙니다.");
        }
    }

    private void checkInputValidation(String data) {
        if(data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public int plus(int first, int second) {
        return first + second;
    }

    public int minus(int first, int second) {
        return first - second;
    }

    public int multiple(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        if(second == 0) {
            throw new IllegalArgumentException("숫자 0으로 나눌 수 없습니다.");
        }
        return first / second;
    }

}
