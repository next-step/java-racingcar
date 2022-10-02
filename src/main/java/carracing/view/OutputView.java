package carracing.view;

import java.util.List;

public class OutputView {

    public void printStart() {
        System.out.println("실행 결과");
    }

    public String printTrail(int position) {
        String result = "";
        for (int i = 0; i < position; i++) {
            result+="-";
        }
        return result;
    }

    public void printBlank() {
        System.out.println("");
    }
}
