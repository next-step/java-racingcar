package step2.model;

public class CalculatorComponents {

    public Integer add(String a,String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    public Integer minus(String a, String b) {
        return Integer.parseInt(a) - Integer.parseInt(b);
    }

    public Integer multiply(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    public Integer divide(String a, String b) {
        return Integer.parseInt(a) / Integer.parseInt(b);
    }

}
