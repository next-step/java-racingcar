package step3.view;

import step3.model.CarList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public ArrayList<Integer> inputView() {
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        inputList.add(scanner.nextInt());

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputList.add(scanner.nextInt());

        return inputList;
    }
}
