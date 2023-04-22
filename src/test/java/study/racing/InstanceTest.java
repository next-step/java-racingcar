package study.racing;

import org.junit.jupiter.api.Test;
import study.racing.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InstanceTest {

    @Test
    void 인스턴스_테스트() {
        InputView inputView1 = InputView.getInstance();
        InputView inputView2 = InputView.getInstance();

        assertThat(inputView1).isSameAs(inputView2);
    }

    @Test
    void 멀티_스레드_싱글톤_테스트() throws InterruptedException {
        List<InputView> instanceList = new ArrayList<>();

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


        InputView initial = instanceList.get(0);
        for (InputView instance : instanceList) {
            assertThat(instance).isSameAs(initial);
        }
    }

    private static Runnable addInstance(List<InputView> instanceList) {
        return () -> {
            InputView instance = InputView.getInstance();
            instanceList.add(instance);
        };
    }
}
