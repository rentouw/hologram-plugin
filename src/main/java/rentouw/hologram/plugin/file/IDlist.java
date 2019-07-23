package rentouw.hologram.plugin.file;

import org.bukkit.Bukkit;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

public class IDlist {

    private static String[] data = new String[5];
    private static String filename = "plugins/ID.yml";
    private static String[] stringBufferOfData = new String[50];

    public static String CheckID(String ID) {
        boolean fileRead;
        fileRead = readFile();
        data[0] = "nope"; // x
        data[1] = "nope"; // y
        data[2] = "nope"; // z
        data[3] = "nope"; // text
        data[4] = "false"; // info text
        if (fileRead && stringBufferOfData != null) {// if the read file was successfull
            try {
                for (int i = 0; i < stringBufferOfData.length; i++) {
                    String string = stringBufferOfData[i];
                    if (string.equals(ID)) {
                        data[0] = stringBufferOfData[(i + 1)]; // x
                        data[1] = stringBufferOfData[(i + 2)]; // y
                        data[2] = stringBufferOfData[(i + 3)]; // z
                        data[3] = stringBufferOfData[(i + 4)]; // text
                        data[4] = "true"; // info text
                    }
                }
            } catch (NullPointerException e) {
                Bukkit.getLogger().info(e.toString());
            }
            return String.join(",", data);
        } else {
            return String.join(",", data);
        }
    }

    private static boolean readFile() {
        AtomicReference<BufferedReader> bufferReader = new AtomicReference<>();
        int i = 0;
        try {
            FileReader fileReader = new FileReader(filename);
            bufferReader.set(new BufferedReader(fileReader));
            stringBufferOfData[0] = bufferReader.get().readLine();
            for (String line = ""; line != null; line = bufferReader.get().readLine()) {
                stringBufferOfData[i] = line;
                i++;
            }
        } catch (IOException e) {
            Bukkit.getLogger().info("IOException");
            return false;
        } finally {
            try {
                if (bufferReader.get() != null) {
                    bufferReader.get().close();
                }
            } catch (IOException e) {
                Bukkit.getLogger().info("IOException=" + e);
                return false;
            }
        }
        return true;
    }

    public static void writeToFile(String info) {
        String[] text = info.split(",");
        readFile();
        AtomicReference<BufferedWriter> bufferedWriter = new AtomicReference<>();
        try {
            FileWriter fileWriter = new FileWriter(filename);
            bufferedWriter.set(new BufferedWriter(fileWriter));

            for (String string : stringBufferOfData) {
                if (string != null) {
                    bufferedWriter.get().write(string);
                    bufferedWriter.get().newLine();
                }
            }

            for (String string : text) {
                bufferedWriter.get().write(string);
                bufferedWriter.get().newLine();
            }
        } catch (IOException e) {
            Bukkit.getLogger().info("IOException=" + e);
        } finally {
            try {
                if (bufferedWriter.get() != null) {
                    bufferedWriter.get().close();
                }
            } catch (IOException e) {
                Bukkit.getLogger().info("IOException=" + e);
            }
        }

    }
}
