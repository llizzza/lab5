import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeletingValue {

    private List<Integer> list;
    private int valueToRemove;

    public DeletingValue(List<Integer> list, int valueToRemove) {
        this.list = new ArrayList<>(list);
        this.valueToRemove = valueToRemove;
    }

    public void removeAll() {
        list.removeIf(x -> x == valueToRemove);
    }

    @Override
    public String toString() {
        return "Список после удаления: " + list;
    }

    public static int readInt(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Введите целое число!");
                sc.next();
            }
        }
    }
}
