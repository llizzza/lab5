import java.io.*;
import java.util.*;

public class ParticipantReader {
    public static List<Participant> readFromFile(String filename) {
        List<Participant> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 0;

            while ((line = br.readLine()) != null) {
                lineNum++;

                String[] parts = line.trim().split("\\s+");
                if (parts.length != 5) {
                    System.out.println("Ошибка в строке " + lineNum + ": неверное количество данных.");
                    continue;
                }

                String surname = parts[0];
                String name = parts[1];

                try {
                    int s1 = Integer.parseInt(parts[2]);
                    int s2 = Integer.parseInt(parts[3]);
                    int s3 = Integer.parseInt(parts[4]);

                    if (s1 < 0 || s1 > 25 || s2 < 0 || s2 > 25 || s3 < 0 || s3 > 25) {
                        System.out.println("Ошибка в строке " + lineNum + ": баллы должны быть от 0 до 25.");
                        continue;
                    }

                    list.add(new Participant(surname, name, s1, s2, s3));

                } catch (NumberFormatException e) {
                    System.out.println("Ошибка в строке " + lineNum + ": баллы должны быть числами.");
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        return list;
    }
}
