package calculator;

public class Calculator {

    public Calculator() {
    }

    public int calculate(String express) {
        if (isBlank(express)) throw new IllegalArgumentException();
        return getResult(splitBlank(express));
    }

    private boolean isBlank(String express) {
        if (express == null) return true;
        if (express.equals(" ")) return true;
        if (express.contains("  ")) return true;
        return false;
    }

    private String[] splitBlank(String express) {
        return express.split(" ");
    }

    private int getResult(String[] data) {
        int sum = 0;
        for (int i = 0; i < data.length - 2; i += 2) {
            if (!isPlus(data[i + 1])) throw new IllegalArgumentException();
            sum += add(Integer.parseInt(data[i]),Integer.parseInt(data[i + 2]));
        }
        return sum;
    }

    private boolean isPlus(String operation) {
        if (operation.equals("+")) return true;
        return false;
    }

    private int add(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

}
