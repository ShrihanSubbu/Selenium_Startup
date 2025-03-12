package org.example;

public class ReverseEachWordOfAString {

    static void reverseEachWordOfString(String inputString) {
        String[] words = inputString.split(" ");

        String reverseString = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            String reverseWord = "";

            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }

            reverseString = reverseString + reverseWord + " ";
        }

        System.out.println(inputString);

        System.out.println(reverseString);

        System.out.println("-------------------------");
    }

    static void revrseWordsinAString(String word){
        String[] wordArray = word.split(" ");
        String reverseWords= "";
        StringBuilder sb = new StringBuilder();
        for (int i=wordArray.length-1;i>=0;i--) {
            reverseWords =wordArray[i];
            if(reverseWords.isBlank())
                continue;
            sb.append(reverseWords);
            if(i!=0)
                sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        reverseEachWordOfString("Java Concept Of The Day");

        reverseEachWordOfString("Java J2EE JSP Servlets Hibernate Struts");

        reverseEachWordOfString("I am string not reversed");

        reverseEachWordOfString("Reverse Me");

        revrseWordsinAString("Java Concept Of The Day");
    }
}
