/*
 * Project : <Name of the Project|Assignment>
 * File : <Name of the source code file>
 * Name : Steven Wade Lewis
 * Date : <Date project due>
 * 
 * Description : (Narrative description, not code)
 */

package hangman;
import java.util.Scanner;

/*
 * @author Wade
 */
public class Hangman 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a word to guess(no caps):");
        String word = input.next();
        char[] answer = new char[word.length()];
        for (int i = 0; i < answer.length; i++ )    //setting up answer array with the letters from the word
        {
            answer[i] = word.charAt(i);
        }
        char[] temp = new char[answer.length]; //temp blanks array
        for(int i = 0; i< temp.length; i++)
        {
            temp[i] = '_';
        }
        int attempts = 6;
        boolean test = false;
        for(int counter = 0;counter<temp.length;counter++)  //first print to let them know how many letters
        {
            System.out.print(temp[counter] + " ");
        }
        do
        {
            System.out.println("Please enter a letter:");
            int lcount = 0;
            char letter = input.next().charAt(0);
            for(int count = 0; count<temp.length;count++)
            {
                if(letter == answer[count] && letter != temp[count]) //added && to stop repeat letter breaking
                {
                    temp[count] = letter;
                } else lcount++;    //added to help attempts counter
            }
            if (lcount == answer.length)    //to see if attempts should be subtracted from
            {
                attempts--;
            }
            System.out.println("your guess:"+ letter);
            for(int counter = 0;counter<temp.length;counter++)  //print temp with letters guessed
            {
                System.out.print(temp[counter] + " ");
            }
            int r =0;
            for(int t = 0; t<temp.length; t++)  //check to see if the arrays are the same to end the game
            {
                if(temp[t] == answer[t])
                {
                    r++;
                }
            }
            if(r == temp.length)
            {
                test = true;
            }
            else
            {
                System.out.println("    You have "+ attempts + " attempts left");
            }
        }while(test != true && attempts > 0);
        if(attempts == 0)
        {
            System.out.print("Sorry the answer was: ");
            for(int counter = 0;counter<answer.length;counter++)
            {
                System.out.print(answer[counter] + " ");
            }
            System.out.println("\nBetter luck next time!");
        }else System.out.print("GREAT JOB! You got it!\n");
    }
}
