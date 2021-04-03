package step3;

import java.util.Random;

public class Racing {

    public void racing() {

        InputView inputView = new InputView();
        inputView.input();

        for (int i = 0; i < inputView.repeat; i++) {
            play(inputView.num);
            System.out.println(" ");
        }
    }

    public void play(int num) {
        for (int i = 0; i < num; i++) {
            ResultView resultView = new ResultView();
            resultView.result(movement());
        }
    }

    public int movement() {
        int count = 1;
        while (random() >= 4) {
            count++;
        }
        return count;
    }

    public int random() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
