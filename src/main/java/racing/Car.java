package racing;


import java.util.List;
public class Car {
    private String carName;
    private String dash = "";
    public Integer movingCar = 0;

    public Car() {

    }
    public void addCar(List<Car> carList) {
        carList.add(new Car());
    }
    public void naming(String[] carsName, List<Car> carList) {
        int index = 0;
        for (Car car : carList) {
            car.carName = carsName[index];
            index++;
            exceptionCarNameCount(car);
        }
    }

    private void exceptionCarNameCount(Car car) {
        if(car.carName.length() > 5){
            throw new IllegalArgumentException("차의 이름은 5자리를 넘을 수 없습니다.");
        }
    }

    public void move(int randomNumber) {
        if(randomNumber >= 4){
            this.dash += "-";
            this.movingCar += 1;
        }
    }


    public String winningCar(List<Car> carList){
        String winningCarName = "";
        Integer temp = 0;
        for (Car car : carList) {
            if(car.movingCar >= temp){
                winningCarName += (car.carName + ",");
                temp = car.movingCar;
            }
        }
        return winningCarName.substring(-0, winningCarName.length() - 1);
    }

    @Override
    public String toString() {
        return carName + " : " + dash;
    }

}
