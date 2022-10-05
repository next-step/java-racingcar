package step3;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public void printResult(int carQuantity, int tryCount) {
        System.out.println("실행 결과");
        CarStorage carStorage = new CarStorage(addCarsToList(carQuantity));
        carStorage.printLocation(tryCount);
    }

    private List<Car> addCarsToList(int carQuantity) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < carQuantity; i++) {
            list.add(new Car("-"));
        }
        return list;
    }
}
