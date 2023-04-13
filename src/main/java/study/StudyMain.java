package study;

import study.race.io.RaceInputView;

public class StudyMain {
    
    public static void main(String[] args) {
        System.out.println("Hello Next-Step !");
        RaceInputView inputView = new RaceInputView();
        inputView.input();

        System.out.println("carNum: " + inputView.getCarNum());
        System.out.println("tryNum: " + inputView.getTryNum());
    }

}
