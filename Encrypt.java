import java.util.Scanner;

public class Encrypt {

    public static Scanner sc;
    public static String text;
    public static char array[] = {'1', 'B', 'c', 'D', '3', 'F', '5', 'G', 'h', 
    'I', '6', 'J', '7', 'K', 'l', 'M', '9', 'N', '0', 'p', 'Q', 
    'r', 'S', 't', 'U', 'v', 'W', 'x', 'Y', 'z', 'A', 'b', 'C', 
    'd', 'E', '4', 'f', 'g', 'H', 'i', '8', 'j', 'k', 'L', 'm', 
    'N', 'O', 'P', 'q', 'R', 's', 'T', 'u', 'V', 'w', 'X', 'y', 'Z'};


    public static void main(String[] args) {

        inputText();
        encrypt();

    }

    public static void inputText() {
        sc = new Scanner(System.in);
        System.out.print("Enter text to encrypt:");
        text = sc.nextLine();
    }

    public static void encrypt() {
        char[] encryptedArray =  new char[text.length()];
        char[] textArray = text.toCharArray();
        char[] reversedArray = new char[text.length()];

        System.out.println("\nEncryption Process");

        int j = textArray.length;
        for (int i = 0; i < textArray.length; i++) {
            reversedArray[i] = textArray[j - 1];
            System.out.println(textArray[i] + " exchanges with " + textArray[j - 1]);
            j--;
        }

        System.out.println();
        for(int i = 0; i < textArray.length; i++) {
            char currentChar = reversedArray[i];
            int index = -1;
            for(int a = 0; a < array.length; a++) {
                if(currentChar == array[a]) {
                    index = a;
                    break;
                }
            }
            if(index != -1) {
                // Encrypt the character
                System.out.print(reversedArray[i] + " becomes " );
                int newIndex = (index + i) % array.length;
                encryptedArray[i] = array[newIndex];
                System.out.print(encryptedArray[i] + "\n");
            } else {
                // Character not found in array, keep it unchanged
                System.out.print(reversedArray[i] + " becomes " );
                encryptedArray[i] = currentChar;
                System.out.print(encryptedArray[i] + "\n");
            }
        }

        System.out.println("\nEncrypted Text:");
        System.out.println(encryptedArray);
    }
}
