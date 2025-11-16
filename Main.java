import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = 0;

        while (true) {
            System.out.print("Введите номер задания (1–7): ");
            try {
                number = scanner.nextInt();

                if (number < 1 || number > 7) {
                    System.out.println("Номер задания должен быть от 1 до 7.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите число!");
                scanner.nextLine();
            }
        }

        switch (number) {
            case 1:
                System.out.println("Задание 1");
                CachedFraction f = new CachedFraction(1, -2);
                System.out.println(f);
                System.out.println(f.toDouble());
                System.out.println(f.toDouble());

                f.setNumerator(3);
                System.out.println(f.toDouble());

                break;

            case 2:
                System.out.println("Задание 2 ");

                Cat cat = new Cat("Барсик");
                CatCounter count = new CatCounter(cat);

                MeowProcessor.makeAllMeow(count, count, count);
                System.out.println("Количество мяуканий: " + count.getCount());
                break;

            case 3:
                System.out.println("Задание 3 ");

                Scanner sc = new Scanner(System.in);

                int n = DeletingValue.readInt(sc, "Введите количество элементов списка: ");

                List<Integer> L = new ArrayList<>();

                System.out.println("Введите элементы списка:");
                for (int i = 0; i < n; i++) {
                    L.add(DeletingValue.readInt(sc, "Элемент " + (i + 1) + ": "));
                }

                int value = DeletingValue.readInt(sc, "Введите значение, которое нужно удалить: ");

                DeletingValue task = new DeletingValue(L, value);

                task.removeAll();

                System.out.println(task);
                break;

            case 4:
                System.out.println("Задание 4 ");

                String filename = "participants";

                List<Participant> participants = ParticipantReader.readFromFile(filename);

                if (participants.isEmpty()) {
                    System.out.println("Нет корректных данных.");
                    return;
                }

                System.out.println("\nВсе участники:");
                for (Participant p : participants) {
                    System.out.println(p);
                }

                System.out.println("\nПобедители:");
                List<Participant> winners = ParticipantAnalyzer.getWinners(participants);
                for (Participant w : winners) {
                    System.out.println(w.getSurname() + " " + w.getName());
                }
                break;

            case 5:
                System.out.println("Задание 5 ");

                try {
                    List<Character> consonants =
                            ConsonantExtractor.extractUniqueConsonants("C:\\Users\\bonda\\IdeaProjects\\untitled\\input.txt");

                    consonants.forEach(System.out::println);

                } catch (IOException e) {
                    System.out.println("Ошибка чтения файла: " + e.getMessage());
                }
                break;

            case 6:
                System.out.println("Задание 6 ");

                Queue<Integer> queue = new LinkedList<>();

                System.out.print("Введите количество элементов: ");
                int o = scanner.nextInt();

                System.out.println("Введите элементы очереди:");
                for (int i = 0; i < o; i++) {
                    queue.add(scanner.nextInt());
                }

                QueueUtils utils = new QueueUtils(queue);

                System.out.println("Очередь: " + utils.toString());

                System.out.print("Введите i1 и j1 (первый участок): ");
                int i1 = scanner.nextInt();
                int j1 = scanner.nextInt();

                System.out.print("Введите i2 и j2 (второй участок): ");
                int i2 = scanner.nextInt();
                int j2 = scanner.nextInt();

                boolean result = utils.areSegmentsEqual(i1, j1, i2, j2);

                System.out.println(result);
                break;

            case 7:
                System.out.println("Задание 7 ");

                System.out.println("Задача 1");
                List<Point> points = List.of(
                        new Point(3, -5),
                        new Point(1, 4),
                        new Point(2, -2),
                        new Point(3, -5),
                        new Point(2, 2)
                );

                Polyline polyline = points.stream()
                        .distinct()
                        .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                        .sorted(Comparator.comparing(Point::getX))
                        .collect(Collectors.collectingAndThen(
                                Collectors.toList(),
                                Polyline::new
                        ));

                System.out.println(polyline);

                System.out.println("Задача 2");
                var resultt = PersonParser.parseFile("C:\\Users\\bonda\\IdeaProjects\\untitled\\people.txt");
                System.out.println(resultt);

                break;

            default:
        }

        scanner.close();
    }
}
