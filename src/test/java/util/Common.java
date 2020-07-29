package util;

public final class Common {

    public static boolean checkValue(String number) {
        try {
            Double.parseDouble(number);
            return false;
        }catch (Exception e) {
            return  true;
        }
    }

}
