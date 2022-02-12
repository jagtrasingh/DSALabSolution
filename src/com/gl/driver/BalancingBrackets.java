package com.gl.driver;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancingBrackets {

 // function to check if brackets are balanced
 static boolean isBracketsBalanced(String sInput)
 {
     // Using ArrayDeque is faster than using Stack class
     Deque<Character> stack
         = new ArrayDeque<Character>();

     // Traversing the Expression
     for (int i = 0; i < sInput.length(); i++)
     {
         char cBracket = sInput.charAt(i);

         if (cBracket == '(' || cBracket == '[' || cBracket == '{')
         {
             // Push the element in the stack
             stack.push(cBracket);
             continue;
         }

         // If current character is not opening
         // bracket, then it must be closing. So stack
         // cannot be empty at this point.
         if (stack.isEmpty())
             return false;
         char check;
         switch (cBracket) {
         case ')':
             check = stack.pop();
             if (check == '{' || check == '[')
                 return false;
             break;

         case '}':
             check = stack.pop();
             if (check == '(' || check == '[')
                 return false;
             break;

         case ']':
             check = stack.pop();
             if (check == '(' || check == '{')
                 return false;
             break;
         }
     }

     // Check Empty Stack
     return (stack.isEmpty());
 }

 // Driver code
 public static void main(String[] args)
 {
     Scanner scanner = new Scanner(System.in);
	 System.out.println("The entered String has Balanced Brackets");
	 String sInput = scanner.nextLine();
     if (isBracketsBalanced(sInput))
         System.out.println("The entered String has Balanced Brackets");
     else
         System.out.println("The entered Strings do not contain Balanced Brackets");
 }
}