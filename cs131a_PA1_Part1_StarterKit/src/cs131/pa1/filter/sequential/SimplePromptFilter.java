package cs131.pa1.filter.sequential;
import cs131.pa1.filter.Message;
import java.io.*;

public class SimplePromptFilter extends SequentialFilter throws Exception{
	private String targetFileName;
	private File targetFile;
	public SimplePromptFilter (Stirng fileName) {
		String[] fileNameSplit = fileName.split(" ");
		if (fileNameSplit.length > 0) {
			targetFileName =  fileNameSplit[1];
		} else {
			throw new Exception (MESSAGE.REQUIRES_PARAMETER.toString(), fileName);
		}
		File targetFile = new File(targetFileName);
		//To get if the file with given name already exists
		//If not, create a new file. If already existed, rewrite with a new file.
		if (targetFile.exists()) {
			targetFile.delete();
		} 
		targetFile.createNewFile();
	}
	protected String processLine(String line) {
		FileWriter fw = new FileWriter(targetFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(line);
		return null;
	}
}
