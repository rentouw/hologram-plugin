package rentouw.hologram.plugin.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;

public class IDlist {

	private static String data[] = new String[5];
	private static String filename = "plugins/ID.txt";
	private static String stringBufferOfData[] = new String[50];

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
		if (fileRead && stringBufferOfData != null) {// if the read file was
														// successfull
			Bukkit.getLogger().info("fileRead = true!");
			for (int i = 0; i < stringBufferOfData.length; i++) {
				String string = stringBufferOfData[i];
				Bukkit.getLogger().info("String string = stringBufferOfData[" + i + "]; == " + string);
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
			Bukkit.getLogger().info("Sdata = !" + Sdata);
			return Sdata;
		} else {
			Bukkit.getLogger().info("fileRead = false OR stringBufferOfData = null");
			String Sdata = String.join(",", data);
			Bukkit.getLogger().info("Sdata = !     " + Sdata);
			return Sdata;
		}
	}

	private static boolean readFile() {
		Bukkit.getLogger().info(" start readfile!");
		BufferedReader bufferReader = null;
		int i = 0;
		try {
			Bukkit.getLogger().info("try");
			FileReader fileReader = new FileReader(filename);
			bufferReader = new BufferedReader(fileReader);
			// Bukkit.getLogger().info("bufferReader.readLine() = " +
			// bufferReader.readLine());
			Bukkit.getLogger().info("start testing stringBufferOfData");
			stringBufferOfData[0] = bufferReader.readLine();

			if (stringBufferOfData == null) {
				Bukkit.getLogger().info("shit stringBufferOfData == null");
			}
			Bukkit.getLogger().info("start wile loop");

			for (String line; (line = bufferReader.readLine()) != null;) {
				stringBufferOfData[i] = line;
				i++;
			}

		} catch (IOException e) {
			Bukkit.getLogger().info("IOException");
			return false;

		} finally {
			Bukkit.getLogger().info("finally");
			try {
				if (bufferReader != null) {
					Bukkit.getLogger().info("if (bufferReader != null)");
					bufferReader.close();
				}
				Bukkit.getLogger().info("finally done");
			} catch (IOException e) {
				Bukkit.getLogger().info("IOException=" + e);
				return false;
			}
		}
		Bukkit.getLogger().info("reading done!");
		return true;
	}

	public static void writeToFile(String info) {
		Bukkit.getLogger().info(" start write!");
		String text[] = info.split(",");
		readFile();
		BufferedWriter bufferedWriter = null;
		try {
			FileWriter fileWriter = new FileWriter(filename);
			bufferedWriter = new BufferedWriter(fileWriter);

			for (String string : stringBufferOfData) {
				if (string !=null){
				Bukkit.getLogger().info("String =" + string);
				bufferedWriter.write(string);
				bufferedWriter.newLine();
				}
			}

			for (String string : text) {
				Bukkit.getLogger().info("String =" + string);
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
	
	/**public static void replaceFileString(String textj, String change) throws IOException {
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
}*/
}
