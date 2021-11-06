package step3.model.view;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OutputView {
    private ArrayList<String> inputCarList;
    private Integer countOfTry;

    public OutputView(ArrayList<String> inputCarList,Integer countOfTry) {
        this.inputCarList = inputCarList;
        this.countOfTry = countOfTry;
    }

    public void outputView() {
        System.out.println("실행 결과");
        for (int i = 0; i < countOfTry; i++) {
            outputView2();
            System.out.println("");
        }
    }

    public void outputView2() {
        for (int i = 0; i < inputCarList.size(); i++) {
            System.out.println(inputCarList.get(i));
        }
    }
}
