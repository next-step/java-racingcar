package racing.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView implements View {

    Scanner sc;

    int count;

    int time;

    public InputView() {
        sc = new Scanner(System.in);
    }

    @Override
    public void render() {
        this.count = inputCount();
        this.time = inputTime();
    }

    private int nextInt(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }

    private int inputCount() {
        return nextInt("자동차 대수는 몇 대 인가요?");
    }

    private int inputTime() {
        return nextInt("시도할 회수는 몇 회 인가요?");
    }

    public int getCount() {
        return count;
    }

    public int getTime() {
        return time;
    }
}
