package _02_FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class PrintWriterText {
	
	public static void main(String[] args) {
		File file = new File("e:/1.txt");
		System.out.println(" 默认编码  "+ Charset.defaultCharset());
		
		try (
				FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw);
				){
			
			pw.println("houlixuan0010");
			pw.println("houlixuan0010");
			pw.println("houlixuan0010");
			pw.println("houlixuan0010");
			pw.append("houlixuan0020");
			pw.append("houlixuan0020");
			pw.append("houlixuan0020");
			pw.append("houlixuan0020");
			pw.println("houliuan");
			pw.println("houliuan");
			pw.println("houliuan");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
