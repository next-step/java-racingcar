package step2;

public class Calculate {

    public static int add(int iNum1, int iNum2) {
        return iNum1 + iNum2;
    }

    public static int subtract(int iNum1, int iNum2) {
        return iNum1 - iNum2;
    }

    public static int multiply(int iNum1, int iNum2) {
        return iNum1 * iNum2;
    }

    public static int divide(int iNum1, int iNum2) {
        Validation.validDivide(iNum1, iNum2);
        return iNum1 / iNum2;
    }

}
