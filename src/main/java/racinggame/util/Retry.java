package racinggame.util;

import java.util.Arrays;
import java.util.function.Supplier;

public class Retry {

    public static <T> T retry(Supplier<T> function, int maxRetries, Class<? extends RuntimeException>... timeoutExceptionClasses) {
        timeoutExceptionClasses = getOrDefaultExceptionClasses(timeoutExceptionClasses);

        int retryCount = 0;
        RuntimeException lastException = null;
        while (retryCount < maxRetries) {
            try {
                return function.get();
            } catch (RuntimeException e) {
                lastException = e;
                if (isContains(e, timeoutExceptionClasses)) {
                    retryCount++;
                    System.err.printf("입력 실패 (%s/%s) 시도 횟수를 초과하면 게임을 강제로 종료합니다.%n", retryCount, maxRetries);
                    System.out.println(e.getMessage());
                    if (retryCount >= maxRetries) {
                        break;
                    }
                    continue;
                }
                throw lastException;
            }
        }
        throw lastException;
    }

    private static Class<? extends RuntimeException>[] getOrDefaultExceptionClasses(
            Class<? extends RuntimeException>[] timeoutExceptionClasses) {
        if (isEmpty(timeoutExceptionClasses)) {
            timeoutExceptionClasses = getDefaultExceptionClasses();
        }
        return timeoutExceptionClasses;
    }

    private static boolean isEmpty(Class<? extends RuntimeException>[] timeoutExceptionClasses) {
        return timeoutExceptionClasses.length == 0;
    }

    private static Class[] getDefaultExceptionClasses() {
        return new Class[]{RuntimeException.class};
    }

    private static boolean isContains(RuntimeException e, Class<? extends RuntimeException>[] timeoutExceptionClasses) {
        return Arrays.stream(timeoutExceptionClasses)
                .anyMatch(tClass -> tClass.isAssignableFrom(e.getClass()));
    }
}
