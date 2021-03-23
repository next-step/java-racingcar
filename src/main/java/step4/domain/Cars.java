package step4.domain;

import step4.util.RandomUtil;
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

    public void start() {
        inputView.inputData();

        carList = this.createdList(inputView.getData());

        this.racing(inputView.getData());

    }

    public List<Car> createdList(Data data) {
        List<Car> list = new ArrayList<>();
        String [] names = data.spliteName(",");
        for(String name : names){
            list.add(new Car(name));
        }
        return list;
    }

    private void racing(Data data) {
        for(int i =0; i< data.getCount(); i++){
            this.drive();
        }
    }

    private void drive() {
        for(Car car : carList){
            car.move(RandomUtil.getRandomValue());
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
