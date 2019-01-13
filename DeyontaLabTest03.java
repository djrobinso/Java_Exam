import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;


/**
 * @author Deyonta
 *
 */
public class DeyontaLabTest03 {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Answering questions number 1 & number 2
		
		//1.Variables
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.#");
		double legA = 0.0;
		double legB = 0.0;
		double hypotenuse = 0.0;
		int [] mileage = new int[50];
		int over = 0;
		
		//2.Prompt the user input
		System.out.println("We are going to calculate the hypotenuse of a triangle.");
		
		System.out.println("Please enter the length of leg A: ");
		legA = keyboard.nextDouble();
		
		System.out.println("Please enter the length of leg B: ");
		legB = keyboard.nextDouble();
		
		//3.Calculate 
		try{
			hypotenuse = calculateHypotenuse(legA, legB);
			System.out.println("The hypotenuse of a triangle with Leg A =" 
							+ legA + " and Leg B = " + legB + " is: "+
							df.format(hypotenuse) + " .");
		}catch(InterruptedException ERROR){
			
			System.out.println(ERROR.getMessage());
			ERROR.printStackTrace();
		}
		
		//4.Print result
		lineBreak();
		
		//5. True/False
		TrueFalse();
		lineBreak();
		
		//6.Load the mileage arrays
		try {
			loadMileage(mileage);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		//7.Reimbursement
		System.out.println("Processing mileage.txt...");
		System.out.println();
		
		printReimbursement(mileage);
		lineBreak();
		
		//8.Determine 500
		countOver500(mileage);
		
		
		//9.Name Maker
		nameMaker();
		System.out.println("End of Program.......Goodbye!");
		
	}//end of main
	
	public static double calculateHypotenuse(double legA, double legB) throws InterruptedException{
		
		if(legA < 1 || legA > 1000)
		{
			throw new InterruptedException("ERROR!!!!! Sorry to tell ya but " 
											+ legA + " is not a valid entry.");
		}
		
		if(legB < 1 || legB > 1000)
		{
			throw new InterruptedException("ERROR!!!!! Sorry to tell ya but " 
											+ legB + " is not a valid entry.");
		}
		
		double value = ( Math.pow(legA,2.0) + (Math.pow(legB,2.0)));
		
		value = Math.sqrt(value);
		
		return value;
	}
	
	public static void TrueFalse(){
		Scanner keyboard = new Scanner(System.in);
		int tries = 0;
		String UserInput = "a";
		
		do{
		System.out.println("Enter T for True or F for False");
		UserInput = keyboard.next();
		tries++;
		if(UserInput == "T"){
			break;
		}
		if(UserInput == "F"){
			break;
		}
		}while(UserInput == "T" || UserInput == "F");
		
		if(tries == 1)
		{
			System.out.println("You have selected " + UserInput + 
					" and it only too you " + tries + " try");
		}
		else
		{	System.out.println("You have selected " + UserInput + 
				" and it only too you " + tries + " tries");
		}
		
	}
	
	public static void lineBreak(){
		System.out.println("-------------------------------------------------------");
	}

	public static int [] loadMileage(int [] mileage)throws FileNotFoundException{
		
		File UserFile = new File("mileage.txt");
		int number = 0;
		int i = 0;
		
		try {
			Scanner reader = new Scanner(UserFile);
			while(reader.hasNext())
			{
				number = reader.nextInt();
				mileage[i] = number;
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR! Sorry but the file could not be found!");
		}
		
		return mileage;
	}
	
	public static void printReimbursement(int [] mileage){
		
		DecimalFormat df = new DecimalFormat("####.##");
		int count = 0;
		System.out.println("Price						Total Reinbursement");
		
		for(int counter = 0; counter < mileage.length; counter++)
		{
			if(mileage[counter] == 0)
			{
				break;
			}else
			{
				System.out.print(mileage[counter]);
				System.out.print("						");
				System.out.print(df.format(mileage[counter]*0.41));
				System.out.println();
				count++;
			}
			
		}
		System.out.println("Successfully processed " + count + " reimbursements");
	
	} 
	
	public static int countOver500(int [] mileage){
		int over = 0;
		for(int index = 0; index < mileage.length; index++)
		{
			if(mileage[index]> 500)
			{over++;}
			if(mileage[index] == 0)
			{break;}
		}
		System.out.println("There were " + over + " entries found that went over 500" );
		return over;
	}
	
	public static void nameMaker(){
		
		Scanner keyboard = new Scanner(System.in);
		String firstname = "";
		String secondname = "";
		String newName = "";
		
		System.out.println("Enter your first mame:");
		firstname = keyboard.nextLine();
		
		System.out.println("Enter your last name:");
		secondname = keyboard.nextLine();
		
		if(firstname.equalsIgnoreCase("Quit")||secondname.equalsIgnoreCase("Quit"))
		{
			System.exit(0);
		}
		
		if(firstname.length() > 3 )
		{
			newName = firstname.substring(0, 2) + secondname.substring(0, secondname.length());
			System.out.println("The name maker has constructed the new name: " + newName);
		}
		else
		{
			newName = firstname.substring(0, firstname.length()) + secondname.substring(0, secondname.length());
			System.out.println("The name maker has constructed the new name: " + newName);
		}
	}
	
}//end of DeyontaLabTest03
