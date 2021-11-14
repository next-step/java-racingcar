package racing.service;

public class ConvertOutputView {

    public static String convertOutputView(Integer position) {
        StringBuilder convertResult = new StringBuilder();
        convertResult.append("-");
        for (int i = 0; i < position; i++) {
            convertResult.append("-");
        }
        return convertResult.toString();
    }
}
