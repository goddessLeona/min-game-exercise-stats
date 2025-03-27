
import java.util.Scanner;


public class SpelStatistik {

    static String[] gamesPlayed = null;

    public static void main(String[] args) {

        welcome();
        String name = teamName();
        System.out.println("Your team is registrated as: " + name);

        totalGames();
        gameResults();
        System.out.println("\nTeam: " + name);
        resultWritten1();

        System.out.println("\nPart 1 excersise done\n");

        countsW();
        countsD();
        countsL();
        countsPoints();
        procentCount();
        longestWin();

    }

    public static void welcome(){

        String n = "\n";
        String welcome= "Welcome to this collect stats for games";
        String instructions = "Folllow the instrucktions to get out the results: ";
        System.out.println(n + welcome + n + instructions + n);
    }

    public static String teamName(){

        Scanner scaneer = new Scanner(System.in);
        String team = "";
        String instructions = "what is the name of your team ?";

        System.out.println(instructions);
        team = scaneer.nextLine();
        return team;

    }

    static public void totalGames(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Putt in how many game's have you played this year ?");

        int count = sc.nextInt();
        gamesPlayed =new String [count];

    }

    static public void gameResults(){

        Scanner sc = new Scanner(System.in);
        int index = gamesPlayed.length;

        String inst = "For every game you played this year add following information";
        String intsruktion = "'v' för wictory, 'O' för oavgjort, 'F' för förlust";
        System.out.println(inst + "\n" + intsruktion + "\n");

        for (int lenght = 0; lenght < index; lenght++){
            System.out.println("in your " + (lenght+1) +" game. What was your result ? " + intsruktion);
            String letter = sc.nextLine();

            switch (letter){
                case "v":
                    gamesPlayed[lenght] = "Victory";
                    break;
                case "o":
                    gamesPlayed[lenght] = "Draw";
                    break;
                case "f":
                    gamesPlayed[lenght] = "loss";
                    break;
                default:
                    System.out.println("you did not add the right letter");
                    lenght--;
                    break;
            }

        }

    }

    static public void resultWritten1(){
        System.out.println("Game Results:");
        for (int i = 0; i < gamesPlayed.length; i++) {
            System.out.println("Game " + (i + 1) + ": " + gamesPlayed[i]);
        }
    }

    static public void countsW(){

        int sumVictory =0;

        for(int i = 0; i< gamesPlayed.length; i++ ){

            if( gamesPlayed[i].equals("Victory")){
                sumVictory++;
            }
        }
        System.out.println("The total Victory during the year are: " +sumVictory);
    }

    static public void countsD(){

        int sumDraw =0;

        for(int i = 0; i< gamesPlayed.length; i++ ){

            if( gamesPlayed[i].equals("Draw")){
                sumDraw++;
            }
        }
        System.out.println("The total Draw's during the year are: " +sumDraw);
    }

    static public void countsL(){

        int sumLoss =0;

        for(int i = 0; i< gamesPlayed.length; i++ ){

            if( gamesPlayed[i].equals("loss")){
                sumLoss++;
            }
        }
        System.out.println("The total Loss during the year are: " +sumLoss);
    }

    static public void countsPoints(){

        int sumVictory =0;
        int sumDraw =0;

        for(int i = 0; i< gamesPlayed.length; i++ ){

            if( gamesPlayed[i].equals("Victory")){
                sumVictory++;
            }if(gamesPlayed[i].equals("Draw")){
                sumDraw++;
            }
        }
        System.out.println("\nThe total Points during the year are: " + (sumVictory *3 + sumDraw));
    }

    static public void procentCount(){

        int sumVictory =0;
        int totalGamesPlayed = gamesPlayed.length;

        for(int i = 0; i< gamesPlayed.length; i++ ){

            if( gamesPlayed[i].equals("Victory")) {
                sumVictory++;
            }
        }
        double victoryProcentage = (double) sumVictory/totalGamesPlayed *100;
        System.out.println("\nThe total wining procentage during the year are: " + String.format("%.2f", victoryProcentage) + "%");
    }

    static public void longestWin(){

        int longVictory =0;
        int longhold=0;

        for(int i = 0; i< gamesPlayed.length; i++ ){

            if( gamesPlayed[i].equals("Victory")) {
                longhold++;
                }else{
                if(longhold>longVictory){
                    longVictory = longhold;
                }
                longhold =0;
            }
        }

        if(longhold > longVictory){
            longVictory = longhold;
        }

        System.out.println("\nThe longest win in a row was: " + longVictory);
    }

}
