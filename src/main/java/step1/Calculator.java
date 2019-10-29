/**
* Step1 계산기
* @author whlee0525
* @version 1.0.0
* @since 2019-10-29 오후 6:16
**/

package step1;

public class Calculator {

    public int calculateSentence(String sentence) {

        String[] dataArr = makeDataArr(sentence);
        int result = calculateDataArr(dataArr);

        return result;
    }

    private String[] makeDataArr(String sentence) {

        if (isNull(sentence)) {
            throw new IllegalArgumentException();
        }

        String[] dataArr = sentence.split(" ");

        if (isBlank(dataArr)) {
            throw new IllegalArgumentException();
        }
        if (isInvalid(dataArr)) {
            throw new IllegalArgumentException();
        }

        return dataArr;
    }

    private boolean isNull(String sentence) {
        if (sentence == null) {
            return true;
        }

        return false;
    }

    private boolean isBlank(String[] dataArr) {
        if (dataArr == null) {
            return true;
        }
        if (dataArr.length == 0) {
            return true;
        }
        return false;
    }

    private boolean isInvalid(String[] dataArr) {
        if (isEvenLength(dataArr)) {
            return true;
        }
        if (isOddDataButNotNumber(dataArr)) {
            return true;
        }
        if (isEvenDataButNotSymbol(dataArr)) {
            return true;
        }

        return false;
    }

    private boolean isEvenLength(String[] dataArr) {
        return (dataArr.length % 2 == 0);
    }

    private boolean isOddDataButNotNumber(String[] dataArr) {
        for (int i = 0; i < dataArr.length; i += 2) {
            try {
                Integer.parseInt(dataArr[i]);
            } catch (NumberFormatException e) {
                return true;
            }
        }
        return false;
    }

    private boolean isEvenDataButNotSymbol(String[] dataArr) {
        for (int i = 1; i < dataArr.length - 1; i += 2) {
            if (!(dataArr[i].equals("+")
                    || dataArr[i].equals("-")
                    || dataArr[i].equals("*")
                    || dataArr[i].equals("/"))) {
                return true;
            }
        }
        return false;
    }

    private int calculateDataArr(String[] dataArr) {
        int result = Integer.parseInt(dataArr[0]);

        for (int i = 1; i < dataArr.length - 1; i = i + 2) {
            String symbol = dataArr[i];
            int firstInt = result;
            int secondInt = Integer.parseInt(dataArr[i + 1]);
            result = symbolCalculator(symbol, firstInt, secondInt);
        }
        return result;
    }


    private int symbolCalculator(String symbol, int a, int b) {
        switch (symbol) {
            case "+":
                return plus(a, b);
            case "-":
                return minus(a, b);
            case "*":
                return multiple(a, b);
            default:
                return division(a, b);
        }
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int multiple(int a, int b) {
        return a * b;
    }

    private int division(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }

}
