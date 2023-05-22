package sortedAndMerge;

import publisher.Publisher;

import java.sql.Array;
import java.util.Arrays;

public class SortedAndMerge implements Runnable{
    private Publisher publisher1;
    private Publisher publisher2;
    private Object[] sortedAndMerge;

    public SortedAndMerge(Publisher publisher1, Publisher publisher2) {
        this.publisher1 = publisher1;
        this.publisher2 = publisher2;
    }


    @Override
    public void run() {
        Publisher[] merge = new Publisher[]{publisher1, publisher2};
        sortedAndMerge = Arrays.stream(merge).sorted().toArray();

    }
}
