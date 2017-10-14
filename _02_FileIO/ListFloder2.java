package _02_FileIO;

import java.io.File;

public class ListFloder2 {

	static long maxSize = 0;
	static long minSize = Integer.MAX_VALUE;
	static File maxFile = null;
	static File minFile = null;

	
	static void listFile(File file){
		
		if (file.isFile()){
			if (file.length()> maxSize){
				maxFile = file;
				maxSize = file.length();
			}
			if (file.length() < minSize && file.length() != 0){
				minFile = file;
				minSize = file.length();
			}
			return;
		}
		
		if (file.isDirectory()){
			File[] fs = file.listFiles();
			if (fs!=null)
				for (File f : fs)
					listFile(f);
			
			
		}
		
		
	}
	
	public static void main(String[] args) {
		File f = new File("c:\\windows");
		listFile(f);
		System.out.println("最大的文件是 " + maxFile.getAbsolutePath() + "大小是" + maxSize);
		System.out.println("最小的文件是 " + minFile.getAbsolutePath() + "大小是" + minSize);
	}
}
