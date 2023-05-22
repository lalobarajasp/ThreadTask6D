import publisher.Publisher;
import sortedAndMerge.SortedAndMerge;
import subscriber.Subscriber;

public class Main {
    public static void main(String[] args) {

        Subscriber subscriber1 = new Subscriber("Eduardo");

        Publisher publisher1 = new Publisher(subscriber1);
        Publisher publisher2 = new Publisher(subscriber1);

        final var valuePublisher1 = publisher1.run();
        final var valuePublisher2 = publisher2.run();


        final var sortedAndMerge = new SortedAndMerge(publisher1,publisher2);

        Thread t1 = new Thread(sortedAndMerge);


        t1.start();
        System.out.println("Sorted and Merge Array");
        print(sortedAndMerge);








    }

    private static void print(SortedAndMerge sortedAndMerge) {
        for(double num : sortedAndMerge) {
            System.out.println(num);
        }
    }


}