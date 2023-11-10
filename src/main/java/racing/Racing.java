package racing;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

import static racing.InputView.*;
import static racing.ResultView.*;

public class Racing {
    private static final int START = 1;
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE = 1;

    public static void main(String[] args) {
        int car_count = car();
        int move_count = move();

        System.out.println("실행 결과");
        doRacing(car_count, move_count);
    }

    public static void doRacing(int carCount, int moveCount) {
        int[] cars = new int[carCount];
        // 초기 시작점 지정
        Arrays.fill(cars, START);

        int max_car_move = Arrays.stream(cars).max().getAsInt();
        while(max_car_move < moveCount){
            for(int index=0; index < carCount; ++index){
                if (checkMove()){
                    cars[index] += MOVE;
                }
            }

            if (max_car_move != Arrays.stream(cars).max().getAsInt()){
                show_status(cars);
                max_car_move = Arrays.stream(cars).max().getAsInt();
            }
        }

        show_result(cars, moveCount);
    }

    public static boolean checkMove() {
        Random random = new Random();
        if(random.nextInt(MAX_RANDOM_NUMBER) >= MOVE_THRESHOLD){
            return true;
        }
        return false;
    }
}