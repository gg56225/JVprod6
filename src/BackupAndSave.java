import java.io.*;
import java.nio.file.*;

public class BackupAndSave {
    public static void main(String[] args) {
        // Убедитесь, что путь к директории правильный
        createBackup("C:/Users/mariw/IdeaProjects/JVprod/source_directory", "./backup");

        // Массив состояний ячеек поля для игры в крестики-нолики
        int[] fieldStates = {0, 1, 2, 0, 1, 2, 0, 1, 2};

        // Запись состояний в файл
        saveFieldStatesToFile(fieldStates, "field_states.dat");
    }

    public static void createBackup(String sourceDir, String backupDir) {
        try {
            Files.createDirectories(Paths.get(backupDir));
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(sourceDir));
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    Files.copy(path, Paths.get(backupDir, path.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFieldStatesToFile(int[] fieldStates, String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int packedStates = 0;
            for (int i = 0; i < fieldStates.length; i++) {
                packedStates |= (fieldStates[i] & 0x03) << (i * 2);
            }
            dos.writeByte((packedStates >> 16) & 0xFF);
            dos.writeByte((packedStates >> 8) & 0xFF);
            dos.writeByte(packedStates & 0xFF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
