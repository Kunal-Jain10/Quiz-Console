import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

abstract class Topic{
    public abstract void topicName();
    public abstract int questions();
}

class Choice{
    public int menu(){
        Scanner ob = new Scanner(System.in);
        System.out.println("1. For Java\n2. For Python\n3. For C++\n4. To exit");
        System.out.println("Enter the Topic for the Quiz: ");
        int topicChoice = 0;
        topicChoice=ob.nextInt();
        return topicChoice;
    }
}


class Java extends Topic{
    public void topicName()
    {
        System.out.println("You Chose Java");
    }

    public int questions()
    {
        Scanner ob = new Scanner(System.in);
        System.out.println("Questions for Java:");
        QuestionModel questions = new QuestionModel();
        ArrayList<String> questionForJava = questions.csv();
        int result=0;
        Quiz response = new Quiz();
        for(int i=0;i<5;i++)
        {
            System.out.println("\n"+questionForJava.get(1)+". "+questionForJava.get(2));
            System.out.println("a)"+questionForJava.get(3)+" b)"+questionForJava.get(4)+" c)"+questionForJava.get(5)+" d)"+questionForJava.get(6));
            String choice = ob.nextLine();
            if(choice.equals(questionForJava.get(7)))
            {
                int res=response.correct();
                result +=res;
            }
            else
            {   
                response.incorrect();
            }
            for(int j=0;j<8;j++)
            {
                questionForJava.remove(0);
            }
        }
        return result;
    }
}

class Python extends Topic {
    public void topicName()
    {
        System.out.println("You chose Python");
    }

    public int questions()
    {
        Scanner ob = new Scanner(System.in);
        System.out.println("Questions for Python:");
        QuestionModel questions = new QuestionModel();
        ArrayList<String> questionForPython = questions.csv();
        int result=0;
        Quiz response = new Quiz();
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<8;j++)
            {
                questionForPython.remove(0);
            }
        }
        for(int i=0;i<5;i++)
        {
            System.out.println("\n"+questionForPython.get(1)+". "+questionForPython.get(2));
            System.out.println("a)"+questionForPython.get(3)+" b)"+questionForPython.get(4)+" c)"+questionForPython.get(5)+" d)"+questionForPython.get(6));
            String choice = ob.nextLine();
            if(choice.equals(questionForPython.get(7)))
            {
                int res=response.correct();
                result +=res;
            }
            else
            {   
                response.incorrect();
            }
            for(int j=0;j<8;j++)
            {
                questionForPython.remove(0);
            }
        }
        return result;
    }
}

class Cpp extends Topic{
    public void topicName()
    {
        System.out.println("You chose C++");
    }

    public int questions()
    {
        Scanner ob = new Scanner(System.in);
        System.out.println("Questions for C++:");
        QuestionModel questions = new QuestionModel();
        ArrayList<String> questionForCpp = questions.csv();
        int result=0;
        Quiz response = new Quiz();
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<8;j++)
            {
                questionForCpp.remove(0);
            }
        }
        for(int i=0;i<5;i++)
        {
            System.out.println("\n"+questionForCpp.get(1)+". "+questionForCpp.get(2));
            System.out.println("a)"+questionForCpp.get(3)+" b)"+questionForCpp.get(4)+" c)"+questionForCpp.get(5)+" d)"+questionForCpp.get(6));
            String choice = ob.nextLine();
            if(choice.equals(questionForCpp.get(7)))
            {
                int res=response.correct();
                result +=res;
            }
            else
            {   
                response.incorrect();
            }
            for(int j=0;j<8;j++)
            {
                questionForCpp.remove(0);
            }
        }
        return result;
    }
}

interface results{
    public int correct();
    public void incorrect();
}

class QuestionModel{
    public ArrayList<String> csv(){
        String file = "C:\\Users\\Kunal\\Quiz.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<String> question = new ArrayList<String>();

        try{
            reader = new BufferedReader(new FileReader(file));
            while((line=reader.readLine())!=null){
                String[] row = line.split(",");
                for(String index : row){
                    question.add(index);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                reader.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        return question;
    }    
}

public class Quiz implements results{
    public int correct(){
        System.out.println("Correct Answer");
        return 1;
    }
    public void incorrect(){
        System.out.println("Incorrect Option");
    }
    
    public static void main(String args[])throws IOException{
        int topicChoice = 0;
        Choice ch = new Choice();
        while(topicChoice!=4)
        {
            topicChoice = ch.menu();       
            switch(topicChoice)
            {
                case 1:
                    Java java = new Java();
                    java.topicName();
                    System.out.println("You Scored: "+java.questions()+"\n");
                    break;
                case 2:                 
                    Python python = new Python();
                    python.topicName();   
                    System.out.println("You Scored: "+python.questions()+"\n");
                    break;
                case 3:                
                    Cpp cpp = new Cpp();
                    cpp.topicName(); 
                    System.out.println("You Scored: "+cpp.questions()+"\n");   
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please choose valid Topic");
                    break;
            }
        }        
    }
}