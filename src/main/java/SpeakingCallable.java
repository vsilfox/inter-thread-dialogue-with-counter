import java.util.concurrent.Callable;

public class SpeakingCallable implements Callable<Integer> {
    final static int MAX_NUMBER_OF_ENTRIES = 10;

    @Override
    public Integer call() {
        int counter = 0;
        for (int i = 0; i < Math.random() * MAX_NUMBER_OF_ENTRIES; i++) {
            System.out.printf("Hello, I am %s!\n", Thread.currentThread().getName());
            counter++;
        }
        return counter;
    }
}
