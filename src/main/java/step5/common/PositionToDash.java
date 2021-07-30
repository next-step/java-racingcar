package step5.common;

public class PositionToDash {
    public static String makeDash(int position) {
        String dash = "";
        for (int count = 0; count < position; count++) {
            dash += "-";
        }
        return dash;
    }
}
