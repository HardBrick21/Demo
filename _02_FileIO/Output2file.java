package _02_FileIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Output2file {
	
	public static void main(String[] args) throws IOException {
	
		File file = new File("e:/file/dile1/lol.txt");
		
		if (!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		
		FileOutputStream outf = new FileOutputStream(file);
		outf.write("侯立玄".getBytes());
		outf.close();
	}

}
