// Bill Ruben
// p.431

import java.util.Scanner;
import java.io.IOException;
public class CalculatorDemo 
{
    public static void main(String[] args) throws IOException
    {
      Scanner input = new Scanner(System.in);
      Process proc = Runtime.getRuntime().exec
      ("cmd /c C:\\Windows\\System32\\calc.exe");  
      double num1 = 9.0;
      double num2 = 4.0;
      double answer = num1 + num2;
      double usersAnswer;
      System.out.print("What is the sum of " + num1 +
        " and " + num2 + "? >> ");
      usersAnswer = input.nextDouble();
      if(usersAnswer == answer)
        System.out.println("Correct!");
      else
        System.out.println("Sorry - the answer is " + answer);
    }    
}
