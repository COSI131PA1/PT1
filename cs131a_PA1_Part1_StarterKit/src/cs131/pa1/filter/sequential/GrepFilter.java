package cs131.pa1.filter.sequential;
import cs131.pa1.filter.Message;

public class GrepFilter extends SequentialFilter throws Exception{
	private String target;
	
	public GrepFilter (String input) {
		super();
		grabTarget(input);
	}
	
	private void grabTarget (String input) {
		//to deal with the case that the target string is a phrase (as described in the link given in instruction)
		if (input.indexOf('\'') != -1) {
			int start = input.indexOf('\'')
			if (input.indexOf('\'',input.indexOf('\'')) != -1) {
				int end = input.indexOf('\'',input.indexOf('\''));
				target = input.substring(start, end+1);
			}
		}
		//to deal with the case that the target string is a single word
		if (target.equals(null)) {
			String[] inputSplit = input.split(" ");
			if(inputSplit.length > 0) {
				target = inputSplit[1];
			}
		}
		//to deal with invalid input
		if (target.equals(null)) {
			throw new Exception(MESSAGE.REQUIRES_PARAMETER.toString(), input);
		}
	}
	protected String processLine (String line) {
		if (line.contains(target)) {
			return line;
		} 
		return null;
	};
}
