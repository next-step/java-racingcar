package step3;

public class InputView {
    static int input1 = 0;
    static int input2 = 0;
    static String [] go;

    public static void inputMethod(String input) {
        String [] inputs = input.split(" ");

        input1 = Integer.parseInt(inputs[0]);
        input2 = Integer.parseInt(inputs[1]);
        go = new String[input1];
        goReset();
    }

    public static void goReset() {
        for(int sl = 0;sl<go.length;sl++){
            go[sl] = "";
        }
    }

}
