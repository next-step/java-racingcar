package step2;

public class StringCalculator {

    public String execute(String strInputData) {

        //실행 시키기전 빈 공백인지 먼저 체크
        Validation.nullValueCheck(strInputData);

        String[] arrValue = strInputData.split(" ");

        int curTotal = Integer.parseInt(arrValue[0]);
        for(int i = 1; i < arrValue.length; i = i + 2) {
            String operation = arrValue[i];
            int iSecondValue = Integer.parseInt(arrValue[i+1]);

            curTotal = calculation(curTotal, iSecondValue, operation);

        }

        return Integer.toString(curTotal);
    }

    private int calculation(int iValue1, int iValue2, String operation) {

        switch (operation) {
            case "+" :
                return Calculate.add(iValue1, iValue2);
            case "-" :
                return Calculate.subtract(iValue1, iValue2);
            case "*" :
                return Calculate.multiply(iValue1, iValue2);
            case "/" :
                return Calculate.divide(iValue1, iValue2);
            default:
                throw new IllegalArgumentException("해당 기호는 사칙연산을 지원하지 않습니다!!!!");
        }
    }
}
