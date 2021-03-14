package step3;

/**
 * STEP3. 자동차 경주
 * 
 * 1. 입력값   : 차량 수, 이동 횟수
 * 2. 전진조건 : 0 ~ 9 사이의 난수를 발생하여 4이상인 경우
 * 
 * @author ddak-ddakong
 *
 */
public class RacingCar {
    
    private int carCount;                           //차량 수
    private int roundCount;                         //이동 횟수
    private String[][] racingCar;                   //차량의 이동정보
    
    private static RacingCar instance;
    
    private RacingCar() {}
    
    private RacingCar(int carCount, int roundCount) {
        this.carCount = carCount;
        this.roundCount = roundCount;
        this.racingCar = new String[carCount][roundCount];
    }
    
    public static RacingCar newInstance() {
        if( instance == null ) {
            instance = new RacingCar();
        }
        return instance;
    }

    public static RacingCar newInstanceByCarMove(int carCount, int roundCount) {
        if( instance == null ) {
            instance = new RacingCar(carCount, roundCount);
        }
        return instance;
    }

    public void setRacingCar(String[][] racingCar) {
        this.racingCar = racingCar;
    }

    public static void setInstance(RacingCar instance) {
        RacingCar.instance = instance;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }
    
    public int getCarCount() {
        return this.carCount;
    }
    
    public int getRoundCount() {
        return this.roundCount;
    }

    public void setCurrentPosition(int carIndex, int roundIndex, String position) {
        this.racingCar[carIndex][roundIndex] = position;
    }
    
    public String getCurrentPosition(int carIndex, int roundIndex) {
        return racingCar[carIndex][roundIndex];
    }
    
    public String[][] getRacingCarInfo() {
        return racingCar;
    }

}    
