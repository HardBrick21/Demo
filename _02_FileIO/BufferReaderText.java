package _02_FileIO;

import java.io.*;
import java.nio.charset.Charset;

public class BufferReaderText {
	
	public static void main(String[] args) {
		
		File file = new File("e:/1.txt");
		
		System.out.println(Charset.defaultCharset());
		
		try (
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				) {
			
			while(true){
			
				String line = br.readLine();
				if (null == line)
					break;
				
				System.out.println(line);
			
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
