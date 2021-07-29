package step3;

public class CarGame {
    private Car[] cars;

    public CarGame(int carCnt, int tryCnt) {
        cars = new Car[carCnt];
        for (int i=0; i<carCnt; i++) {
            cars[i] = new Car(tryCnt);
        }
        this.cars = cars;
    }

    public int getAllCar() {
        return cars.length;
    }

    public Car getCar(int i) {
        return cars[i];
    }

    public void canMove(int carIdx, int randomNum) {
        int curMove = cars[carIdx].getMove();
        int curPlay = cars[carIdx].getPlay();

        //4미만일때는 시도횟수만줄임
        if (randomNum < 4) {
            cars[carIdx].setPlay(curPlay - 1);
            return;
        }

        //4이상일때는 전진하고 시도횟수 줄임
        cars[carIdx].setMove(curMove + 1);
        cars[carIdx].setPlay(curPlay - 1);
    }

    public String printDistance(int carIdx) {
        int curMove = cars[carIdx].getMove();

        StringBuilder sb = new StringBuilder();
        while (curMove-- > 0){
            sb.append("-");
        }

        return sb.toString();
    }
}
