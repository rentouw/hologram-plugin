package rentouw.hologram.plugin.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;

public class IDlist {

	private static String data[] = new String[5];
	private static String filename = "plugins/ID.yml";
	private static String stringBufferOfData[] = new String[50];

	public static String CheckID(String ID) {
		boolean fileRead = false;
		fileRead = readFile();
		data[0] = "nope"; // x
		data[1] = "nope"; // y
		data[2] = "nope"; // z
		data[3] = "nope"; // text
		data[4] = "false"; // info text
		if (fileRead && stringBufferOfData != null) {// if the read file was
														// successfull
			try {
				for (int i = 0; i < stringBufferOfData.length; i++) {
					String string = stringBufferOfData[i];
					if (!string.equals("null") || string != null) {
						if (string.equals(ID)) {
							data[0] = stringBufferOfData[(i + 1)]; // x
							data[1] = stringBufferOfData[(i + 2)]; // y
							data[2] = stringBufferOfData[(i + 3)]; // z
							data[3] = stringBufferOfData[(i + 4)]; // text
							data[4] = "true"; // info text
						}
					}
				}
			} catch (NullPointerException e) {
				Bukkit.getLogger().info(e.toString());
			}
			String Sdata = String.join(",", data);
			return Sdata;
		} else {
			String Sdata = String.join(",", data);
			return Sdata;
		}
	}

	private static boolean readFile() {
		BufferedReader bufferReader = null;
		int i = 0;
		try {
			FileReader fileReader = new FileReader(filename);
			bufferReader = new BufferedReader(fileReader);
			stringBufferOfData[0] = bufferReader.readLine();
			for (String line; (line = bufferReader.readLine()) != null;) {
				stringBufferOfData[i] = line;
				i++;
			}

		} catch (IOException e) {
			Bukkit.getLogger().info("IOException");
			return false;

		} finally {
			try {
				if (bufferReader != null) {
					bufferReader.close();
				}
			} catch (IOException e) {
				Bukkit.getLogger().info("IOException=" + e);
				return false;
			}
		}
		return true;
	}

	public static void writeToFile(String info) {
		String text[] = info.split(",");
		readFile();
		BufferedWriter bufferedWriter = null;
		try {
			FileWriter fileWriter = new FileWriter(filename);
			bufferedWriter = new BufferedWriter(fileWriter);

			for (String string : stringBufferOfData) {
				if (string != null) {
					bufferedWriter.write(string);
					bufferedWriter.newLine();
				}
			}

			for (String string : text) {
				bufferedWriter.write(string);
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			Bukkit.getLogger().info("IOException=" + e);
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				Bukkit.getLogger().info("IOException=" + e);
			}
		}

	}
}
