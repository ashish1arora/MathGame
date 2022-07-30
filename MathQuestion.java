public class MathQuestion extends Question {
    @Override
    public int Question(int v1, int v2, String v3){
        value1=v1;
        value2=v2;
        value3 = v3;
        switch (value3) {
            case "+":
            case "0":
                correct = value1 + value2;
                break;
            case "-":
            case "1":
                correct = value1 - value2;
                break;
            case "*":
            case "2":
                correct = value1 * value2;
                break;
            case "/":
            case "3":
                if (value1 % value2 != 0) {
                    correct = (value1 * value2) / value2;
                    return correct;
                }
                correct = value1 / value2;
                break;
        }
        return correct;
    }

    @Override
    public String showQuestion(){
        String question = "";
        switch (value3) {
            case "+":
            case "0":
                question = "What is " + value1 + "+" + value2 + "?\n";
                break;
            case "-":
            case "1":
                question = "What is " + value1 + "-" + value2 + "?\n";
                break;
            case "*":
            case "2":
                question = "What is " + value1 + "*" + value2 + "?\n";
                break;
            case "/":
            case "3":
                if (value1 % value2 != 0) {
                    question = "What is " + value1 * value2 + "/" + value2 + "?\n";
                    return question;


                }
                question = "What is " + value1 + "/" + value2 + "?\n";
                break;
        }

        return question;
    }

    @Override
    public boolean checkAnswer(int response, int answer){

        if(response==answer)
        {
            System.out.println("Right answer\n");
            return true;
        }
        else
        {
            System.out.println("Answer is wrong, The correct answer is "+answer+"\n");
            return false;
        }

    }


}