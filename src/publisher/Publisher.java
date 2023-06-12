package publisher;

import contract.Subscriber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

public class Publisher implements Callable<Double> {
    private final ArrayList<Double> numbers;

    public Publisher(int count) {
        this.numbers = generateRandomNumber(count);
    }



    public ArrayList<Double> generateRandomNumber(int upperBound) {
        Random random = new Random();
        ArrayList<Double> list = new ArrayList<>();

        System.out.println("generateRandomNumber thread running...");
        for (int i = 0; i < upperBound; i++) {
            double rand = random.nextDouble(1000); //int 0 - 999
            list.add(rand);
        }

        return list;

    }

    public double averageXMod3(ArrayList<Double> list) {
        double count = 0;

        System.out.println("averageXMod3 thread running...");
        for (Double listEach : list) {
            double hold = listEach % 3;
            count += hold;
        }
        double result = count / list.size();

        return  result;
    }


    @Override
    public Double call() throws Exception {
        ArrayList<Double> number = generateRandomNumber(1000000);
        double average = averageXMod3(number);
        return average;
    }
}
