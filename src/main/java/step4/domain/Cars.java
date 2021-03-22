package step4.domain;

import step4.view.InputView;
import step4.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    InputView inputView;
    ResultView resultView;
    List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void start() {
        inputView.inputData();

        this.createdList(inputView.getData());

        this.racing(inputView.getData());

    }

    public void createdList(Data data) {
        String [] names = data.spliteName(",");
        for(String name : names){
            carList.add(new Car(name));
        }
    }

    private void racing(Data data) {
        for(int i =0; i< data.getCount(); i++){
            this.drive();
        }
    }

    private void drive() {
        for(Car car : carList){
            car.move();
            this.renderMove(car);
        }
        System.out.println();
    }

    private void renderMove(Car car) {
        if(car.isMoving()){
            resultView.render(car);
        }
    }

}
