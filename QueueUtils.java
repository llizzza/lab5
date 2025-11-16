import java.util.*;

public class QueueUtils {

    private Queue<Integer> queue;

    public QueueUtils(Queue<Integer> q) {
        this.queue = new LinkedList<>(q);
    }

    public boolean areSegmentsEqual(int i1, int j1, int i2, int j2) {
        List<Integer> list = new ArrayList<>(queue);

        if (i1 < 0 || j1 >= list.size() || i2 < 0 || j2 >= list.size())
            throw new IllegalArgumentException("Индексы выходят за пределы очереди");

        if (i1 > j1 || i2 > j2)
            throw new IllegalArgumentException("Начальный индекс больше конечного");

        if ((j1 - i1) != (j2 - i2))
            return false;

        List<Integer> s1 = list.subList(i1, j1 + 1);
        List<Integer> s2 = list.subList(i2, j2 + 1);

        return s1.equals(s2);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
