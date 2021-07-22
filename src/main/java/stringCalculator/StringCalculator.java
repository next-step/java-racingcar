package stringCalculator;

public class StringCalculator {

    public String sum(String a, String b) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        return (aInt + bInt) + "";
    }

    public String diff(String a, String b) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        return (aInt - bInt) + "";
    }

    public String mult(String a, String b) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        return (aInt * bInt) + "";
    }

    public String div(String a, String b) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        return (aInt / bInt) + "";
    }

}
