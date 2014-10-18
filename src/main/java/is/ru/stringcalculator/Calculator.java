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

		return sum(splitNumbers(text));

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


   private static String handleString(String numbers){
   		
		numbers = numbers.replace("\n" , ",");
		numbers = numbers.replace("-" , "");
		String del = "\n";
	
		if(numbers.contains("//[") ){

			numbers = numbers.replace("," , "");
			numbers = numbers.replaceAll("[^\\d]+", " ");
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

		StringBuilder newnumber = new StringBuilder();
		String[] oldnumber = splitNumbers(number);
		for(String numb : oldnumber){
		    if (	toInt(numb) < 1000){
		    	newnumber.append(numb);
		    	newnumber.append(",");}
			}

	return newnumber.toString();
	}

	private static void throwExceptionWithNegativeNumbers(String number) {
        String[] negatives = number.split(",");
        if (number.contains("-")) {
            throw new IllegalArgumentException("Negative numbers not allowed: ");
                   // + extractNegativeNumbers(negatives));
        }
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

