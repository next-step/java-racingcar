package racing;

public class PrintUtil {
    public static void drawPosition(int position) {
        String drawValue = "";
        for (int i = 0; i < position; i++) {
            drawValue += "-";
        }
        System.out.println(drawValue);
    }
}
