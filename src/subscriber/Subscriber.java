package subscriber;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Subscriber implements contract.Subscriber {
    private final String name;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void email(double average) {
        System.out.println(name + " received average: " + average);
    }


    public CompletableFuture<Void> processAverages(Future<Double> future1, Future<Double> future2) {
        CompletableFuture<Double> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                return future1.get();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0;
            }
        });

        CompletableFuture<Double> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                return future2.get();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0;
            }
        });

        return CompletableFuture.allOf(completableFuture1, completableFuture2)
                .thenAccept((Void) -> {
                    double average1 = completableFuture1.join();
                    double average2 = completableFuture2.join();
                    double overallAverage = (average1 + average2) / 2.0;
                    email(overallAverage);
                });


    }



}
