package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void createdList(Data data) {
        String[] names = data.spliteName(",");
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public int topGrade(){
        int grade = 0;
        for(Car car : carList){
            grade = car.bestScore(grade);
        }
        return grade;
    }

}
