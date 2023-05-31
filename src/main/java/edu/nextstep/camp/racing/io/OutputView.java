



package edu.nextstep.camp.racing.io;

public class OutputView {

    public static void printAnswerVehicleCount(){
        print("자동차 대수는 몇 대 인가요?");
    }

    public static void printAnswerMovingCount(){
        print("시도할 회수는 몇 회 인가요?");
    }

    public static void print(String msg){
        System.out.println(msg);
    }



    private OutputView() {
    }
}
