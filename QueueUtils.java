import java.util.Iterator;
import java.util.Queue;

public class QueueUtils {

    public static <T> boolean isSegmentEqualIterator(Queue<T> queue, int i, int j) {
        if (queue == null || i < 0 || j >= queue.size() || i >= j) {
            return false;
        }

        Iterator<T> it = queue.iterator();
        int index = 0;
        T first = null;

        while (it.hasNext()) {
            T value = it.next();

            if (index == i) {
                first = value;
            }

            if (index > i && index <= j) {
                if (!value.equals(first)) {
                    return false;
                }
            }

            index++;
        }

        return true;
    }
}
