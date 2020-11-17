package racingcar;

public class MoveCar {

    public void moveCar(){
        for(int j = 0; j < move; j++){
            tryToMoveResult();
            // resultView.racingResult(carList.stream().map(Car::getLocation).collect(Collectors.toList()));
        }
    }

    public void tryToMoveResult(){
        for(int k = 0; k < carList.size(); k++){
            if(tryToMove() == true){
                Car car = carList.get(k);
                car.moveLocation(k);
                carList.set(k, car);
            }
        }
    }

    public boolean tryToMove(){
        boolean result = false;
        int random = (int)(Math.random()*9);

        if(random >=4){
            result = true;
        }

        return result;
    }
    
}