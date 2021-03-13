package study.racingcar.domain;

public class RacingCar {

    private static final int MOVE_POSSIBLE_NUMBER = 4;
    private int position;
    private final String name;

    public RacingCar(int position, String name) {

        this.position = position;

        carNameValidCheck(name);

        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void oneStep(int number){
        if(movePossible(number)) {
            carMove();
        }
    }

    public String getPrintInfo(){

        StringBuilder result = new StringBuilder(name + " : ");
        for(int i = 0; i < position; i ++){
            result.append("-");
        }
        return result.toString();
    }

    private boolean movePossible(int number) {
        return number >= MOVE_POSSIBLE_NUMBER;
    }

    private void carMove(){
        this.position += 1;
    }

    private void carNameValidCheck(String carName) {
        if(carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 까지 사용 가능 합니다. 입력하신 차의 이름은 : " + carName + " 입니다.");
        }
    }

}
