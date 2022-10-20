package racing.view;

import racing.msg.SystemMention;
import racing.utils.CheckUtil;
import racing.utils.SplitUtil;
import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    private static final Scanner sc = new Scanner(System.in);

    public int inputCntOfTry() {
        SystemMention.CNT_OF_TRY.printMention();
        return inputCnt();
    }

    private int inputCnt() {
        String cntOfCar = sc.nextLine();
        while (!CheckUtil.checkPositive(cntOfCar)) {
            cntOfCar = sc.nextLine();
        }
        return Integer.parseInt(cntOfCar);
    }

    public List<Car> inputCarList() {
        SystemMention.CAR_LIST.printMention();
        return inputCars(inputNames());
    }

    private List<Car> inputCars(String[] names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private String[] inputNames() {
        String names = sc.nextLine();
        while (!CheckUtil.checkStrToArray(names)) {
            names = sc.nextLine();
        }
        return SplitUtil.strToArray(names);
    }
}
