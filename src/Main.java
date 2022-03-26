import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    static Date date = new Date();
    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        dirCreate("D://Games/src");
        dirCreate("D://Games/res");
        dirCreate("D://Games/savegames");
        dirCreate("D://Games/temp");
        dirCreate("D://Games/src/main");
        dirCreate("D://Games/src/test");
        dirCreate("D://Games/res/drawables");
        dirCreate("D://Games/res/vectors");
        dirCreate("D://Games/res/icons");

        fileCreate("D://Games/src/main/Main.java");
        fileCreate("D://Games/src/main/Utils.java");
        fileCreate("D://Games/temp/temp.txt");

        try (FileWriter writer = new FileWriter("D://Games/temp/temp.txt")) {
            writer.write(String.valueOf(log));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        GameProgress gameProgress1 = new GameProgress(100, 1, 1, 50);
        GameProgress gameProgress2 = new GameProgress(80, 2, 3, 85);
        GameProgress gameProgress3 = new GameProgress(60, 5, 8, 125);

        GameProgress.saveGames("D://Games/savegames/save1.dat", gameProgress1);
        GameProgress.saveGames("D://Games/savegames/save2.dat", gameProgress2);
        GameProgress.saveGames("D://Games/savegames/save3.dat", gameProgress3);

        ArrayList<String> pathsToFiles = new ArrayList<>();
        pathsToFiles.add("D://Games/savegames/save1.dat");
        pathsToFiles.add("D://Games/savegames/save2.dat");
        pathsToFiles.add("D://Games/savegames/save3.dat");

        GameProgress.zipFiles("D://Games/zip.zip", pathsToFiles);
    }

    public static void dirCreate(String path) {
        File dir = new File(path);
        if (dir.mkdir()) {
            log.append("Директория " + dir.getName() + " создана по адресу " + dir.getPath() + "\t" + date.toString() + "\n");
        }
    }

    public static void fileCreate(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) ;
            {
                log.append("Файл " + file.getName() + " создан по адресу " + file.getPath() + "\t" + date.toString() + "\n");
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
