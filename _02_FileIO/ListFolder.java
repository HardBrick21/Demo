package _02_FileIO;

import java.io.File;

public class ListFolder {
	
	public static void main(String[] args) {
		File file = new File("c:/windows");
		
		System.out.println("是否存在" + file.exists());
		
		File[] fs = file.listFiles();
		//int x = 0;
		//for (; x< fs.length ; x++){
		//	System.out.println(fs[x]);
		//}
		
		if (null == fs)
			return;
		
		
		long maxSize = 0;
		long minSize = Integer.MAX_VALUE;
		File maxFile = null;
		File minFile = null;
		
		for (File f : fs){
			if (f.isDirectory())
				continue;
			
			if (f.length() > maxSize) {
				maxSize = f.length();
				maxFile = f;
			}
			
			if (f.length() < minSize && f.length() >0){
				minSize = f.length();
				minFile = f;
			}
			
		}
		
		System.out.println("最大的文件是" + maxFile + "大小是" + maxSize);
		System.out.println("最小的文件是" + minFile + "大小是" + minSize);
		
		
		
		
		
		
		
		//long maxFile = 0;
		//long minFile = 0;
		//int maxNO = 0;
		//int minNO = 0;
		//
		//int i = 1;
		//
		//if (fs[i].isFile()){
		//	for (; i<fs.length; i++){
		//		if (fs[i].length() > fs[i-1].length()){
		//			maxFile = fs[i].length();
		//			maxNO = i;
		//		}
		//	}
		//}
		//System.out.println("最大的文件是" + fs[maxNO] +"大小是 " + maxFile);
		//int j = 1;
		//if (fs[j].isFile()) {
		//	for (; j < fs.length; j++) {
		//		if (fs[j].length() < fs[j - 1].length() && fs[j].length() > 0) {
		//			minFile = fs[j].length();
		//			minNO = j;
		//		}
		//	}
		//}
		//System.out.println("最小的文件是" + fs[minNO] +"大小是 " + minFile);
		//
		//
		
	}
}
