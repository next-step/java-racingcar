package step4.domain;

import step4.dto.Data;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public Cars(List<Car> list) {
        carList = list;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void createList(Data data) {
        String[] names = data.spliteName();
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public int topGrade() {
        int grade = 0;
        for (Car car : carList) {
            grade = car.bestScore(grade);
        }
        return grade;
    }

}
