import java.io.*;
import java.util.*;

public class ParticipantAnalyzer {

    public static void solve(String filename) {
        Map<String, Integer> scores = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            int N = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                String[] parts = line.split(" ");

                String surname = parts[0];
                String name = parts[1];
                String key = surname + " " + name;

                int a = Integer.parseInt(parts[2]);
                int b = Integer.parseInt(parts[3]);
                int c = Integer.parseInt(parts[4]);

                int sum = a + b + c;

                scores.put(key, sum);
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        int maxSum = Collections.max(scores.values());

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() == maxSum) {
                System.out.println(entry.getKey());
            }
        }
    }
}
