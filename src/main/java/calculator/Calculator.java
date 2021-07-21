package calculator;

public class Calculator {

    private Calculator() {
    }

    public static int calc(String givenData) {
        if (givenData == null || givenData.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] datas = givenData.split(" ");

        CalcOperator lastSign = null;

        int resultSum = Integer.parseInt(datas[0]);

        for (int i = 1; i < datas.length; i++) {
            String data = datas[i];

            if (Character.isDigit(data.charAt(0))) {
                resultSum = lastSign.calc(resultSum, Integer.parseInt(data));
            } else {
                lastSign = CalcOperator.find(data);
            }
        }

        return resultSum;
    }
}
