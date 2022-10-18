package racing.view;

import racing.utils.CheckUtil;
import racing.utils.SplitUtil;

import java.util.Scanner;

public class UserInput {

    private static final Scanner sc = new Scanner(System.in);

    public int inputCntOfCar() {
        String cntOfCar = sc.nextLine();
        while (!CheckUtil.checkPositive(cntOfCar)) {
            cntOfCar = sc.nextLine();
        }
        return Integer.parseInt(cntOfCar);
    }

    public String[] inputNames() {
        String names = sc.nextLine();
        while (!CheckUtil.checkStrToList(names)) {
            names = sc.nextLine();
        }
        return SplitUtil.strToArray(names);
    }
}
