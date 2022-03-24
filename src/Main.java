import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        final List<String> DIR_LIST = new ArrayList<>(Arrays.asList(
                "Games/src",
                "Games/res",
                "Games/savegames",
                "Games/temp",
                "Games/src/main",
                "Games/src/test",
                "Games/res/drawables",
                "Games/res/vectors",
                "Games/res/icons"
        ));

        final List<String> FILE_LIST = new ArrayList<>(Arrays.asList(
                "Games/src/main/Main.java",
                "Games/src/main/Utils.java",
                "Games/temp/temp.temp.txt"
        ));

        for (String newDir : DIR_LIST) {
            File dir = new File(newDir);
            if (dir.mkdir()) {
                sb.append(dir.getAbsolutePath() + " - директория создана\n");
            } else {
                sb.append(dir.getAbsolutePath() + " - ошибка при создании директории\n");
            }
        }

        for (String newFile : FILE_LIST) {
            try {
                File file = new File(newFile);
                if (file.createNewFile()) {
                    sb.append(file.getAbsolutePath() + " - файл создан\n");
                } else {
                    sb.append(file.getAbsolutePath() + " - ошибка при создании файла\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sb);
        writeFile(sb);
    }

    public static void writeFile(StringBuilder sb) {
        try (FileWriter wf = new FileWriter("Games/temp/temp.temp.txt", false)) {
            wf.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}
