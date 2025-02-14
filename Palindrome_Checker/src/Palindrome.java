import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) throws Exception {

        //calling objects and variables
        Scanner sc = new Scanner(System.in);
        StringBuilder sb;

        String word;
        boolean visiting = true;

        //begin interface loop
        while(visiting) {
            //builds string builder so that it refreshes each time the user repeats the process
            sb = new StringBuilder();
        
            System.out.print("Enter a word and I'll tell you if it's a palindrome: ");
            word = sc.nextLine();

            //removes all spaces from user input
            for(int i = 0; i < word.length(); i++) {
                if(word.charAt(i) != ' ') {
                    sb.append(word.charAt(i));
                }
            }
            word = sb.toString();

            //calls the recursion method and assigns it to a boolean
            boolean isPali = paliCheck(word, 0, word.length() - 1);

            //result based on boolean
            if(isPali) {
                System.out.println(word + " is a palindrome!");
            } 
        
            if(!isPali){
                System.out.println(word + " is not a palindrome. sorry.");
            }

            //asks user if they'd like to test another word
            boolean question = true;
            while(question) {
                System.out.print("would you like to test another word? yes/no: ");
                String answer = sc.nextLine();

                if(answer.equalsIgnoreCase("yes")) {
                    word = "";
                    visiting = true;
                    question = false;
                } else if(answer.equalsIgnoreCase("no")) {
                    System.out.println("Goodbye");
                    visiting = false;
                    question = false;
                } else {
                    System.out.println("I didn't understand that");
                }
            }
        }

        //closes scanner
        sc.close();
    }

    //recursion method
    //scans the string from both sides to check if it's a palindrome
    //if the two letters match from both sides, the method is called again
    //this time both sides moving toward the center of the word by one letter at a time
    public static boolean paliCheck(String word, int left, int right) {
        if(left >= right) {
            return true;
        } 
        
        if(word.charAt(left) != word.charAt(right)) {
            return false;
        }

        return paliCheck(word, left + 1, right - 1);
    }
}
