package study.racing;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.racing.controller.RacingGame;
import study.racing.view.InputView;
import study.racing.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.*;

public class InstanceTest {

    @Test
    void 인스턴스_테스트() {
        InputView inputView1 = InputView.getInstance();
        InputView inputView2 = InputView.getInstance();

        ResultView resultView1 = ResultView.getInstance();
        ResultView resultView2 = ResultView.getInstance();

        RacingGame racingGame1 = RacingGame.getInstance();
        RacingGame racingGame2 = RacingGame.getInstance();

        assertThat(inputView1).isSameAs(inputView2);
        assertThat(resultView1).isSameAs(resultView2);
        assertThat(racingGame1).isSameAs(racingGame2);
    }

    @Test
    void 멀티_스레드_싱글톤_테스트() throws InterruptedException {
        List<RacingGame> instanceList = new ArrayList<>();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(addInstance(instanceList));
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }


        RacingGame initial = instanceList.get(0);
        for (RacingGame instance : instanceList) {
            assertThat(instance).isSameAs(initial);
        }
    }

    private static Runnable addInstance(List<RacingGame> instanceList) {
        return () -> {
            RacingGame instance = RacingGame.getInstance();
            instanceList.add(instance);
        };
    }
}
