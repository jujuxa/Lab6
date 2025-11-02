import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Stream;

public class FileWork {
    public static void main(String[] args) throws IOException {
        String surname = "Dzhantaev";
        String name = "Baiel";

        Path root = Paths.get(surname);
        Files.createDirectories(root);

        Path namefile = root.resolve(name);
        Files.createFile(namefile);

        Path nestedDir = root.resolve("dir1/dir2/dir3");
        Files.createDirectories(nestedDir);
        Files.copy(namefile, nestedDir.resolve(name), StandardCopyOption.REPLACE_EXISTING);

        Files.createFile(root.resolve("dir1/file1"));
        Files.createFile(root.resolve("dir1/dir2/file2"));

        try (Stream<Path> paths = Files.walk(root)) {
            paths.forEach(p -> {
                if (Files.isDirectory(p)) {
                    System.out.println("D: " + p.getFileName());
                } else {
                    System.out.println("F: " + p.getFileName());
                }
            });
        }

        try (Stream<Path> paths = Files.walk(root.resolve("dir1"))) {
            paths.sorted((p1, p2) -> -p1.compareTo(p2))
                    .forEach(p -> {
                        try {
                            Files.delete(p);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }

        try (Stream<Path> stream = Files.walk(root)) {
            stream.sorted((a, b) -> -a.compareTo(b))
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}