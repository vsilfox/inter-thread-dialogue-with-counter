import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    final static int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) {
        final SpeakingCallable speakingCallable = new SpeakingCallable();
        final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            futures.add(executorService.submit(speakingCallable));
        }
        try {
            Thread.sleep(1000);
            executorService.shutdown();
            for (int i = 0; i < futures.size(); i++) {
                System.out.format("Number of thread-%s entries: %s\n", i + 1, futures.get(i).get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
