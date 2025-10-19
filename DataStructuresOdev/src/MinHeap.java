import java.util.Arrays;

public class MinHeap<T extends Comparable<? super T>> implements MinHeapInterface<T> {
    private T[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MinHeap() {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY + 1];
        size = 0;
    }

    public void add(T newEntry) {
        ensureCapacity();
        size++;
        heap[size] = newEntry;
        percolateUp(size);
    }

    public T removeMin() {
        if (isEmpty()) return null;
        T root = heap[1];
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        percolateDown(1);
        return root;
    }

    public T getMin() {
        if (isEmpty()) return null;
        return heap[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        while (!isEmpty()) removeMin();
    }

    private void ensureCapacity() {
        if (size >= heap.length - 1) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    private void percolateUp(int index) {
        int parentIndex = index / 2;
        T temp = heap[index];
        while (index > 1 && temp.compareTo(heap[parentIndex]) < 0) {
            heap[index] = heap[parentIndex];
            index = parentIndex;
            parentIndex = index / 2;
        }
        heap[index] = temp;
    }

    private void percolateDown(int index) {
        int childIndex = 2 * index;
        T temp = heap[index];

        while (childIndex <= size) {
            if (childIndex < size && heap[childIndex + 1].compareTo(heap[childIndex]) < 0) {
                childIndex++;
            }

            if (heap[childIndex].compareTo(temp) < 0) {
                heap[index] = heap[childIndex];
                index = childIndex;
                childIndex = 2 * index;
            } else {
                break;
            }
        }
        heap[index] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            sb.append(heap[i]).append(" ");
        }
        return sb.toString().trim();
    }
}