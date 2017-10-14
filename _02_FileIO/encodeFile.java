package _02_FileIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class encodeFile {
	
	public static void encodFile(File encodingFile, File encodedFile) throws IOException {
		
		FileWriter fw = new FileWriter(encodingFile);
		FileReader fr = new FileReader(encodedFile);
		
		char[] all = new char[(int) encodedFile.length()];
		
		fr.read(all);
		fw.write(all);
		for (int x = 0; x<all.length; x++){

			if (all[x] < 9 && all[x]>=0 )
				all[x]+=1;
			if (all[x] == 9)
				all[x]=0;
			if (all[x]>='a' && all[x]< 'z' )
				all[x]+=1;
			if (all[x] == 'z')
				all[x]='a';
			if (all[x] >= 'A' && all[x] < 'Z')
				all[x]+=1;
			if (all[x] == 'Z')
				all[x]= 'A';
			
			
		}
		
		fw.close();
		fr.close();
		
		
	}
	
	
	
}
