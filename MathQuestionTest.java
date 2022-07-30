import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathQuestionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);


    }

    /**
     *  testing question
     */
    @Test
    public void out() {
        MathQuestion q1 = new MathQuestion();
        q1.Question(3, 5, "+");
        String que=q1.showQuestion();

        assertEquals("What is 3+5?\n", que);
    }
    /**
     * High score testing by providing pre values to of high score and current score
     */
    @Test
    public void HighScore() {
        MainProgram main = new MainProgram();

        main.answers= 10;
        main.highest= 10;
        main.Highest();
        assertEquals(10, 10);
    }



    /**
     * response testing for check answer object
     */
    @Test
    void testCreate1() {
        MathQuestion q1 = new MathQuestion();

        int a= q1.Question(3, 4, "+");
        assertFalse(q1.checkAnswer(0,a));

        assertTrue(q1.checkAnswer(7,a));
    }

    @Test
    /*
      This object is for checking answer

     */

    void testCreate2() {
        MathQuestion q1 = new MathQuestion();

        int a= q1.Question(3, 4, "-");
        assertFalse(q1.checkAnswer(0,a));
        assertTrue(q1.checkAnswer(-1,a));
    }
}