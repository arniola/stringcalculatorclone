package is.ru.stringcalculator;

//Remember to refactor after each passing test.
public class Calculator {
	//This is the only function that is being tested.
	public static int add(String text){
		
		text = handleString(text);

		if(text.equals("")){
			return 0;
		}

		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		
		else
			return 1;
	}
//The functions below are only tested FROM the add funtion.
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

	   	//String delimitercheck = numbers.substring(0,1);
		numbers = numbers.replace("\n" , ",");
		String del = "\n";
		if(numbers.equals("")){
			return numbers;
		}

		else if(numbers.contains("//")){
			del = numbers.substring(2,3);
			numbers = numbers.substring(3);
			numbers = numbers.replace(del , ",");

			return numbers;
		}
		else{
			return numbers;
		}

	}

}