package step3;

import java.util.Random;
import java.util.Scanner;

/**
 * STEP3. 자동차 경주
 * 
 * 1. 입력값   : 차량 수, 이동 횟수
 * 2. 전진조건 : 0 ~ 9 사이의 난수를 바러생하여 4이상인 경우
 * 
 * @author ddak-ddakong
 *
 */
public class RacingCar {
    private final int MAX_RANDOM_NUMBER = 10;       //랜덤값 최대 바운드
    private final int MOVE_CONDITION_NUMBER = 4;    //차량의 이동조건
    private final int FIRST_ROUND_NUMBR = 0;        //첫 라운드 인덱스
    private final String CAR_MOVEMENT = "-";        //차량의 이동표기
    
    private int carInput;                           //차량 수
    private int roundCount;                          //이동 횟수
    private String[][] racingCar;                   //차량의 이동정보
    
    private Random random;
    
    private static RacingCar instance;
    
    private RacingCar() {
        random = new Random();
    }
    
    private RacingCar(int carCount, int roundCount) {
        this.carInput = carCount;
        this.roundCount = roundCount;
        
        _initRacingInfo();
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
    
    private boolean _isFirstRound(int roundIndex) {
        return roundIndex == FIRST_ROUND_NUMBR ? true : false;
    }
    
    private void _initRacingInfo() {
        racingCar = new String[carInput][roundCount];
    }
    
    public void inputView() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("자동차 대수는 몇 대 인가요?");
        carInput = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        roundCount = scanner.nextInt();
        
        scanner.close();
        
        _initRacingInfo();
    }
    
    public void resultView() {
        System.out.println("\n실행 결과");
        
        for( int moveCount = 0 ; moveCount < roundCount ; moveCount++ ) {
            for( int carIndex = 0 ; carIndex < carInput ; carIndex++ ) {
                System.out.println(racingCar[carIndex][moveCount]);
            }
            System.out.println();
        }
    }
    
    public boolean isMoveForward() {
        if( random.nextInt(MAX_RANDOM_NUMBER) >= MOVE_CONDITION_NUMBER ) {
            return true;
        }
        return false;
    }
    
    public void goSingleRound(int roundIndex) {
        for( int carIndex = 0 ; carIndex < carInput ; carIndex++ ) {

            if( _isFirstRound(roundIndex) ) {
                racingCar[carIndex][roundIndex] = CAR_MOVEMENT;
                continue;
            }

            racingCar[carIndex][roundIndex] = racingCar[carIndex][roundIndex - 1];
            
            if( isMoveForward() ) {
                racingCar[carIndex][roundIndex] += CAR_MOVEMENT;
            }
        }        
    }

    public void goFullRace() {
        for( int moveCount = 0 ; moveCount < roundCount ; moveCount++ ) {
            goSingleRound(moveCount);
        }
    }
}
