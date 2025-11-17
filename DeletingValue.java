import java.util.List;

public class DeletingValue {

    public static <T> void removeAllOccurrences(List<T> list, T value) {
        list.removeIf(element -> element.equals(value));
    }

}
