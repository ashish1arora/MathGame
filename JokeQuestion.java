import java.util.Random;

public class JokeQuestion extends Question{
    String question;
    int answer;
    String jokes;
    /**
     * This class is for returning the answer
     *
     */
    @Override
    public int Question(int v1, int v2, String v3) {

    return answer;
    }
    /**
     * This class is for showing the Joke question
     *
     */
    @Override
    public String showQuestion() {
        Random random=new Random();
        int randomly = random.nextInt(3);

        if (randomly ==0) {
            question ="How many flies does it take to screw in a light bulb\n";
            answer =2;
            jokes ="No the light bulb will change when it's ready\n";
        }
        if (randomly ==1) {
            question ="How many hands does it take to change a light bulb\n";
            answer =0;
            jokes =", but don't ask me how they got in there\n";
        }
        if(randomly==2){
            question ="How many psychiatrists does it take to change a light bulb?\n";
            answer =0;
            jokes ="Haha okay\n";
        }
        return question;

    }
    /**
     * This class is use for Checking Answer.
     *
     */
    @Override
    public boolean checkAnswer(int response,int answer) {


        if(response==answer)
        {
            System.out.println("Right answer\n");
            return true; }

        else
        {
            System.out.println(answer + jokes);
            return false;
        }

    }
}