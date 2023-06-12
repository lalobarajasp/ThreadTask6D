import publisher.Publisher;
import subscriber.Subscriber;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Subscriber subscriber = new Subscriber("Subscriber");

        Callable<Double> publisher1 = new Publisher(1_000_000);
        Callable<Double> publisher2 = new Publisher(1_000_000);

        Future<Double> future1 = executorService.submit(publisher1);
        Future<Double> future2 = executorService.submit(publisher2);

        try {
            subscriber.processAverages(future1, future2).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();


    }

}