package _02_FileIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer2file {
	
	public static void main(String[] args) throws IOException {
		File file = new File("e:/file.txt");
		
		FileWriter fw = new FileWriter(file);
		
		fw.write("侯立玄");
		fw.close();
		
		FileReader fr = new FileReader(file);
		
		char[] chars = new char[(int) file.length()];
		
		fr.read(chars);

		for (char b : chars)
			System.out.println(b);
		
		//for (int x = 0; x<chars.length ;x++)
		//	System.out.println(chars[x]);
		
		fr.close();
		
		if (file.exists())
			file.delete();
	}
}
