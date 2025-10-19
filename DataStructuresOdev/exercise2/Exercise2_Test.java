import java.util.*;
public class Exercise2_Test {
    public static void main(String[] args) {
        List<Integer>data=Arrays.asList(45,20,14,12,31,7,11,13);

        PriorityQueue<Integer>heap=new PriorityQueue<>(data);

        System.out.println("Heap İçeriği:");
        while(!heap.isEmpty()){
            System.out.println(heap.poll()+" ");
        }
    }
}
