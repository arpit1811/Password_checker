import java.util.Random;

public class Suggest {

    static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lower = "abcdefghijklmnopqrstuvwxyz";
    static String numbers = "0123456789";
    static String special = "!@#$%^&*";

    static String all = upper + lower + numbers + special;

    public static String[] getSuggestions(String username) {

        String[] suggestions = new String[3];

        for (int i = 0; i < 3; i++) {
            suggestions[i] = generatePassword(username);
        }

        return suggestions;
    }

    private static String generatePassword(String username) {

        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(rand.nextInt(upper.length())));
        password.append(lower.charAt(rand.nextInt(lower.length())));
        password.append(numbers.charAt(rand.nextInt(numbers.length())));
        password.append(special.charAt(rand.nextInt(special.length())));

        int remaining = 8 + rand.nextInt(5) - 4; 
        for (int i = 0; i < remaining; i++) {
            password.append(all.charAt(rand.nextInt(all.length())));
        }

        char[] chars = password.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = rand.nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        String finalPass = new String(chars);

        if (finalPass.toLowerCase().contains(username.toLowerCase())) {
            return generatePassword(username);
        }

        return finalPass;
    }

    public static void main(String[] args){
    String[] arr = getSuggestions("shivansh123");

    for (String s : arr) {
        System.out.println(s);
        
        }
    }
}