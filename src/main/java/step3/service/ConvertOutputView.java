package step3.service;

public class ConvertOutputView {

    public static String convertOutputView(Integer position) {
        String convertResult = "-";
        for (int i = 0; i < position; i++) {
            convertResult += "-";
        }
        return convertResult;
    }
}
