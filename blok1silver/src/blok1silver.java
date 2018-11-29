import java.util.*;

public class blok1silver {

    static public void guess(String word, int life) {

        char[] filler = new char[word.length()];
        int i = 0;
        while (i < word.length()) {
            filler[i] = '-';
            if (word.charAt(i) == ' ') {
                filler[i] = ' ';
            }
            i++;
        }
        System.out.print(filler);
        System.out.println("     levens over=" + life);

        ArrayList<Character> l = new ArrayList<Character>();


        Scanner s = new Scanner(System.in); // leest de characters

        while (life > 0) {


//            System.out.println("\als je klaar bent om te spelen click ENTER en als je wilt stoppen type stop");
            String input = s.next();

            if (input.equals("stop")) {
                System.exit(1);
            }


            if (!Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z").contains(input)) {
                System.out.println("dit is verboden!\n doe een andere letter!");
                continue;
            }
//
//


//            System.out.println("mag je dit invoeren?");
            char x = input.charAt(0); // character input door gebruiker
            if (l.contains(x)) {
                System.out.println("al gebruikt");
                continue; //terwijl loop bezig is
            }

            l.add(x);

            if (word.contains(x + "")) {
                for (int y = 0; y < word.length(); y++) { //deze loop checkt voor indexes van de letter
                    if (word.charAt(y) == x) {         // en zal een '-' er voor in de plaats doen
                        filler[y] = x;                 //het character
                    }
                }
            } else {
                life--; //-1 leven als het ingevoerde character niet klopt
            }

            if (word.equals(String.valueOf(filler))) { //controleert of de filler heztzelfde is als woord
                System.out.print(filler);
                System.out.println(" Je hebt gewonnen!");
                break;
            }

            System.out.print(filler);
            System.out.println("     levens over=" + life);

        }
        if (life == 0) {
            System.out.println("je hebt verloren :(");
        }


    }


    public static void main(String[] args) {
        System.out.println("welkom bij galgje\n je moet een woord raden\n als je een letter fout raad gaat er een leven van af");


        String word = "galgje"; // het woord die je moet raden
        int life = 15;
        guess(word, life);


    }
}