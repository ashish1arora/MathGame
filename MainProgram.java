import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;
/**
 * main program
 */
public class MainProgram {
    public String choice;
    public int end=1;
    int highest;
    int answers =0;

    public static void main(String[] args) {
        MainProgram main = new MainProgram();
        main.playfullyGame();


/*
  Creating objects to make program easier and reusable
 */
    }

    public void Highest() {
        if(answers > highest){
            highest = answers;
            System.out.println("Your new high score is"+ highest +"\n");
            return;
        }

        System.out.println("Your high score is"+ highest +"\n");
    }

    /**
     * This object asks the user about the game start
     *
     *
     */

    public void playfullyGame(){
        System.out.println("Welcome to the quiz game\n");
        System.out.println("lets Start the quiz\n");
        Scanner input= new Scanner(System.in);
        while(end!=0){
            playGame();
            Highest();
            System.out.println("Do you want to play another round\n");
            choice=input.next();
            if(choice.equals("yes") || choice.equals("YES") || choice.equals("y") || choice.equals("Y")){
                System.out.println("And let's begin\n");
                answers =0;
            }
            else
            {System.out.println("Alright exiting.....\n");
                end=0;
            }
        }
    }
    /**
     * This class Plays the game where two loops are executed on does the
     * question storing and the other answer checking
     *
     *
     */

    public void playGame() {
        ArrayList<String> question = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        Scanner input= new Scanner(System.in);
        Random rand= new Random();
        boolean goods;
        String ques;
        int ans;
        Random rand1=new Random();
        Random rand2=new Random();
        MathQuestion q1 = new MathQuestion();
        JokeQuestion q2= new JokeQuestion();
        System.out.println("This program only takes integer as input anything else will be make the program exit\n");

/*
  Here we using For loop to initialise random values and random operator which
  will be going for 8 times.
 */

        for(int i=0;i<10;i++)
        {
            int v1 = rand.nextInt(12)+1;
            int v2 = rand1.nextInt(12)+1;
            int RandomObject = rand2.nextInt(4);
            String v3;

            /*
              Deceiving operators here using if else conditions
             */
            if(RandomObject ==0)
                v3="+";
            else if(RandomObject ==1)
                v3="-";
            else if(RandomObject ==2)
                v3="*";
            else v3="/";
            if(i<=8){
            ans = q1.Question(v1, v2, v3);
            ques = q1.showQuestion();
            question.add(ques);
            answer.add(ans);}
            if(i==9) {
                ques= q2.showQuestion();
                ans= q2.Question(v1, v2, v3);
                question.add(ques);
                answer.add(ans);

            }

        }
        int size=question.size();

        for(int i=0;i<question.size();i++) {
            System.out.println(question.get(i));
            int response;
            try {
                response = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error Program is exiting.....!\n");
                return;
            }
            if( i==size-1){
                goods=q2.checkAnswer(response,answer.get(i));
            }
            else {
            goods =q1.checkAnswer(response,answer.get(i));
            }

            if(goods)
            { answers++;
            }
            else
                {
                question.add(question.get(i));
                answer.add(answer.get(i));
                if(i<=size-1){
                    answers--;}
                }
            }

        System.out.println("Total no. of correct answers are "+ answers +"\n");
        if(answers >=0&& answers <=4){
            System.out.println(" Need to Start studying\n");
        }
        if(answers >=5&& answers <=7){
            System.out.println("Not bad but still play for Another success \n");
        }
        if(answers >=8&& answers <=10){
            System.out.println("very good game\n");
        }
    }
}