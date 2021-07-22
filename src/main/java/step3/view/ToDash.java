package step3.view;

public class ToDash {
    public static String positionToDash(int position) {
        String dash = "";
        for (int i = 0; i < position; i++) {
            dash += "-";
        }
        return dash;
    }
}
