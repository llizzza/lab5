import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class PersonParser {

    public static Map<Integer, List<String>> parseFile(String fileName) {
        try {
            return Files.lines(Paths.get(fileName))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(line -> line.split(":"))
                    .filter(arr -> arr.length == 2 && !arr[1].isBlank())
                    .collect(Collectors.groupingBy(
                            arr -> Integer.parseInt(arr[1].trim()),
                            Collectors.mapping(
                                    arr -> normalizeName(arr[0]),
                                    Collectors.toList()
                            )
                    ));

        } catch (Exception e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
    }

    private static String normalizeName(String name) {
        name = name.trim().toLowerCase();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
