package racingcar;

import java.util.ArrayList;

public class ResultView {

    public ResultView() {
    }

    public void print(ArrayList<ArrayList<Integer>> result) {
        StringBuilder sb = new StringBuilder();
        for(ArrayList<Integer> roundResult: result) {
            for(int carState : roundResult) {
                for(int i=0; i<carState; i++){
                    sb.append("-");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
