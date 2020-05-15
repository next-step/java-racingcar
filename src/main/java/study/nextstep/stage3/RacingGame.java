package study.nextstep.stage3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    interface Renderer {
        public void render(GameStatus status);
        public void renderFirstStatus(GameStatus status);
    }

    class DefaultStandardIORenderer implements Renderer{
        @Override
        public void render(GameStatus status) {
            for( int i = 0 ; i < status.size() ; i ++ ){
                System.out.println("-".repeat(status.renderCarPostion(i)));
            }
            System.out.println("");
        }

        @Override
        public void renderFirstStatus(GameStatus status) {
            System.out.println("실행 결과");
            render(status);
        }
    }

    class GameStatus {
        Random randomModule;
        ArrayList<Integer> status;
        public GameStatus(int cars) {
            randomModule = new Random();
            status = new ArrayList<>();
            for( int i = 0 ; i < cars ; i ++ ){
                status.add(1);
            }
        }

        public void setRandomModule(Random randomModule){
            this.randomModule = randomModule;
        }

        public void turn() {
            for( int i = 0 ; i < status.size() ; i ++ ){
                if( 4 <= randomModule.nextInt(10) ){
                    status.set(i, status.get(i) + 1);
                }
            }
        }

        public int size() {
            return status.size();
        }

        public int renderCarPostion(int car) {
            return status.get(car);
        }
    }

    int count;
    GameStatus gameStatus;
    Renderer renderModule;

    public RacingGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int cars = sc.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int count = sc.nextInt();

        this.count = count;
        gameStatus = new GameStatus(cars);
    }

    public RacingGame(int cars, int count) {
        this.count = count;
        gameStatus = new GameStatus(cars);
    }

    public RacingGame setRandomModule(Random randomModule){
        gameStatus.setRandomModule(randomModule);
        return this;
    }

    public void game(){
        renderModule.renderFirstStatus(gameStatus);
        for( int turn = 0 ; turn < count ; turn ++ ){
            gameStatus.turn();
            renderModule.render(gameStatus);
        }
    }
}
