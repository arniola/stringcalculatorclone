package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Remember to refactor after each passing test.
public class Calculator {
	//This is the only function that is being tested.


	public static int addnums(String text){
		if(text.equals("")){
			return 0;
		}

		throwExceptionWithNegativeNumbers(text);
		text = handleString(text);
		text = removeBigNumbers(text);

		if(text.contains(",")){
			return sum(splitNumbers(text));
		}

    	else 

			return 1;
	}
//The functions below are only tested FROM the addnums funtion.



	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

   private static String[] splitLines(String numbers){
	    return numbers.split("\n");
	}
	

   private static String handleString(String numbers){
   		
		numbers = numbers.replace("\n" , ",");
		numbers = numbers.replace("-" , "");
		String del = "\n";
	
		if(numbers.equals("")){
			return numbers;
		}
		
		else if(numbers.contains("//[") ){
			/*
			Pattern MY_PATTERN = Pattern.compile("\\[(.*?)\\]");
   			Matcher m = MY_PATTERN.matcher(numbers);
			while (m.find()) {
			   del = m.group(1);
			    // del now contains "delimiter"
			}*/
			//numbers = numbers.substring(6);
			//numbers = numbers.replace("\\]" , ",");
			//numbers = numbers.replace("\\[" , ",");

			//þegar strengur kemur hingar lítur hann 
			//svona út. //[***],1***2***3
			numbers = numbers.replace("," , "");
			//svona út. //[***]1***2***3

			numbers = numbers.replaceAll("[^\\d]+", " ");
			//svona út. //[***]1***2***3
			numbers = numbers.substring(1);
			numbers = numbers.replace(" " , ",");
			return numbers;
		}

		else if(numbers.contains("//") ){
			del = numbers.substring(2,3);
			numbers = numbers.substring(3);
			numbers = numbers.replace(del , ",");

			return numbers;
		}

		else{
			return numbers;
		}

	}

	private static String removeBigNumbers(String number){
		if(number.equals("")){
			return number;
		}

		StringBuilder newnumber = new StringBuilder();
		String[] oldnumber = splitNumbers(number);
		for(String numb : oldnumber){
		    if (	toInt(numb) < 1000){
		    	newnumber.append(numb);
		    	newnumber.append(",");}
			}
		//newnumber = newnumber.substring(0);

	return newnumber.toString();
	}

	private static void throwExceptionWithNegativeNumbers(String number) {
        String[] negatives = number.split(",");
        if (number.contains("-")) {
            throw new IllegalArgumentException("Negative numbers not allowed: ");
                   // + extractNegativeNumbers(negatives));
        }
    }
    //tekur inn  ***,1***2***3
    private static String detectDelimiter(String number) {
    	String del = number.substring(0,1);
    	number.trim().replaceAll(del, " ");
    	return number;
        }

}
//komment delete
/*
     private static String[] extractNegativeNumbers(String[] numbers){

 	    String[] negatives = new String[5];
        for(String number : numbers){
        	if (toInt(number) < 0)

		    	negatives.add(toInt(number));
		}
		return negatives;
    }
*/

