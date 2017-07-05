package rentouw.hologram.plugin.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.bukkit.Bukkit;

public class IDlist {

	private static String stringBufferOfData[];
	private static String filename = "plugins/ID.yml";
	private static String data[];
	
	public static String CheckID(String ID) {
		Bukkit.getLogger().info("START CHECKID!");
		boolean fileRead = false;
		fileRead = readFile();
		Bukkit.getLogger().info(" readfile done!");
		data[0] = "nope"; // x
		data[1] = "nope"; // y
		data[2] = "nope"; // z
		data[3] = "nope"; // text
		data[4] = "false"; // info text
		Bukkit.getLogger().info("Set data to nope and false done");
		if (fileRead) {// if the read file was successfull
			Bukkit.getLogger().info("fileRead = true!");
			for (int i = 0; i < stringBufferOfData.length; i++) {
				String string = stringBufferOfData[i];
				Bukkit.getLogger().info("String string = stringBufferOfData[i]; == " + string);
				if (string == ID) {
					Bukkit.getLogger().info("found id!");
					data[0] = stringBufferOfData[(i + 1)]; // x
					data[1] = stringBufferOfData[(i + 2)]; // y
					data[2] = stringBufferOfData[(i + 3)]; // z
					data[3] = stringBufferOfData[(i + 4)]; // text
					data[4] = "true"; // info text
				}
			}
			String Sdata = String.join(",", data);
			Bukkit.getLogger().info("Sdata = !     " + Sdata);
			return Sdata;
		} else {
			Bukkit.getLogger().info("fileRead = false");
			String Sdata = String.join(",", data);
			Bukkit.getLogger().info("Sdata = !     " + Sdata);
			return Sdata;
		}
	}

	private static boolean readFile() {
		Bukkit.getLogger().info(" start readfile!");
		// This will reference one line at a time
		String line = null;

		try {
			Bukkit.getLogger().info(" start try catch loop!");
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(filename);
			Bukkit.getLogger().info(" bestand gelezen!");
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Bukkit.getLogger().info("BufferedReader gemaakt!");
			
			while ((line = bufferedReader.readLine()) != null) {
				if (line == null){
					Bukkit.getLogger().info("line == null!");
				}else{
				int a = stringBufferOfData.length;
				stringBufferOfData[(a + 1)] += line;
				Bukkit.getLogger().info("stringBufferOfData == " + stringBufferOfData);
				}
			}
			
			Bukkit.getLogger().info("Klaar met while loop ga nu bestand sluiten!");
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			Bukkit.getLogger().info("Unable to open file '" + filename + "'");
			return false;
		} catch (IOException ex) {
			Bukkit.getLogger().info("Error reading file '" + filename + "'");
			// Or we could just do this:
			// ex.printStackTrace();
			return false;
		}
		Bukkit.getLogger().info("reading done!");
		return true;
	}

	public static void writeToFile(String info) {
		Bukkit.getLogger().info(" start write!");
		String text[] = info.split(",");

		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(filename);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.
			for (int j = 0; j < text.length; j++) {
				bufferedWriter.write(text[j]);
				bufferedWriter.newLine();
			}

			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + filename + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	public static void replaceFileString(String textj, String change) throws IOException {
		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(filename);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.
			for (int j = 0; j < stringBufferOfData.length; j++) {
				if (stringBufferOfData[j] == change) {
					stringBufferOfData[j].replaceAll(change, textj);
				}
			}
			// Always close files.
			bufferedWriter.close();
			String info = String.join(",", stringBufferOfData);
			writeToFile(info);
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + filename + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}
}
