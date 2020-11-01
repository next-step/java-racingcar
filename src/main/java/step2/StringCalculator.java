package step2;

public class StringCalculator {

    public int calculate(String data) {
        checkInputValidation(data);

        String[] splitData = data.split(" ");

        int result = checkNumberValue(splitData[0]);
        for(int i = 1; i < splitData.length; i+=2) {
            result = Operator.calculate(result, splitData[i], checkNumberValue(splitData[i+1]));
        }

        return result;
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
}
