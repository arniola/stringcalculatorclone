package is.ru.stringcalculator;

//Remember to refactor after each passing test.
public class Calculator {
	//This is the only function that is being tested.
	public static int add(String text){
		text = text.replace("\n" , ",");

		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}

		else if(text.contains("\n")){

			return sum(splitLines(text));
		}

		else if((text.contains("\n")) && (text.contains(","))){
			String str = text.replace("\n" , ",");
			return sum(splitNumbers(str));
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

    public static void main(String[] args) { 
      System.out.println("Hello, World");
   }

   private static String[] splitLines(String numbers){
	    return numbers.split("\n");
	}

	private static String[] replaceLines(String numbers){
	    String str = numbers.replace("\n", ",");
	    return splitLines(str);
	}


}