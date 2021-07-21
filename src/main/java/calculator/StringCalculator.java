package calculator;

public class StringCalculator {
    public int calculator(String value){
        String[] values = value.split(" ");
        checkBeforeCalculate(values);
        return excute(values);
    }

    public int excute(String[] values){
        int result = Integer.parseInt(values[0]);
        Integer number = null;
        String sign = null;
        for(int index=2; index<values.length; index+=2){
            number = Integer.parseInt(values[index]);
            sign = values[index-1];
            result = Calculator.calculate(result,number,sign);
        }
        return result;
    }

    public void checkBeforeCalculate(String[] arr) {
        for (String str : arr) {
            isEmptyOrNull(str);
        }
    }

    private void isEmptyOrNull(String str) {
        if(str == null || str.equals("")) {
            throw new IllegalArgumentException("빈 공백문자 또는 null을 입력하면 안됩니다.");
        }
    }
}
