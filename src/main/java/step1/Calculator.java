package step1;

public class Calculator {

    public Calculator() {

    }

    //더하기
    public int sum(int a, int b) {
        return a + b;
    }

    //뺄셈
    public int minus(int a, int b) {
        return a - b;
    }

    //곱셈
    public int multiply(int a, int b) {
        return a * b;
    }

    //나눗셈
    public int divide(int a, int b) {
        return (int) (a / b);
    }


    private int executeExp(int num, int resultNum, String sign) {
        return SignKind.getSign(sign).calculate(resultNum, num);
    }


    private boolean isWrongSignData(String sign) {
//        return !(sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/"));
        return SignKind.getSign(sign).equals(null);
    }

    private boolean isEmptyData(String str) {
        return str == null || str.equals(" ");
    }

    //잘못된 기호가 들어있을 경우
    public boolean checkInputSignWrongData(String[] resultArr) {

        for (int i = 1; i < resultArr.length; i += 2) {
            if (isWrongSignData(resultArr[i])) {
                return true;
            }
        }

        return false;
    }

    //비어있는 문자가 있을 경우
    public boolean checkInputEmptyData(String[] resultArr) {
        for (int i = 0; i < resultArr.length; i++) {
            if (isEmptyData(resultArr[i])) {
                return true;
            }
        }
        if (resultArr.length == 0) {
            return true;
        }
        return false;
    }

    private String[] divideBlank(String expression) throws InputWrongSignDataException, InputEmptyDataException {
        String[] resultArr = null;

        try {
            resultArr = expression.split(" ");
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new NullPointerException("입력값이 NULL입니다.");
        }
        if (checkInputSignWrongData(resultArr)) {
            throw new InputWrongSignDataException("잘못된 기호가 입력되었습니다.");
        }
        if (checkInputEmptyData(resultArr)) {
            throw new InputEmptyDataException("비어있는 문자가 있습니다.");
        }

        return resultArr;
    }

    public int execute(String expression) throws InputWrongSignDataException, InputEmptyDataException {

        //빈공백을 중심으로 수식 쪼개기
        String[] dividedExpArr = divideBlank(expression);
        int dividedExpArrSize = dividedExpArr.length;
        int resultNum = Integer.parseInt(dividedExpArr[0]);
        for (int i = 1; i < dividedExpArrSize; i += 2) {

            int num = Integer.parseInt(dividedExpArr[i + 1]);

            String sign = dividedExpArr[i];

            resultNum = executeExp(num, resultNum, sign);
        }
        return resultNum;
    }


    public static void main(String[] args) throws InputWrongSignDataException, InputEmptyDataException {
        String expression = "2 + 4 * 5";
        int result = new Calculator().execute(expression);
        System.out.println("result ==" + result);
    }
}
