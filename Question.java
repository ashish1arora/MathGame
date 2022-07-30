public abstract class Question {
    public int value1;
    public int value2;
    public String value3;
    public int correct;

    /**
     * This class is use for solving the question
     *
     */
    public abstract int Question(int v1, int v2, String v3);

    /**
     * This class is use for generating the question
     *
     */

    public abstract String showQuestion();

    /**
     * This class is use for checking answer
     *
     */

    public abstract boolean checkAnswer(int response, int answer);
}