package step3.model.view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private Integer CountOfTry;

    public Integer getCountOfTry() {
        return CountOfTry;
    }

    public ArrayList<String> InputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        Integer CountOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.CountOfTry = scanner.nextInt();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < CountOfCar; i++) {
            arrayList.add("-");
        }
        return arrayList;
    }
}
