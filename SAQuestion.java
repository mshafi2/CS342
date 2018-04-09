
import java.io.PrintWriter;
import java.util.Scanner;

public class SAQuestion extends Question
{
	
	public SAQuestion(String question, double val)
	{
		super(question,val);
	}

	public SAQuestion(Scanner scanner)
	{
		super(scanner);
		
		SAAnswer answer = new SAAnswer(scanner);
		rightAnswer = answer;
	}
		
	public Answer getNewAnswer(String ans) 
	{
			
		SAAnswer answer = new SAAnswer(ans);
		return answer;
	}
	
	public Answer getNewAnswer() 
	{
			
		SAAnswer answer = new SAAnswer(questions);
		return answer;
	}

		
	public void getAnswerFromStudent() 
	{
		super.print();
			
		Scanner S = new Scanner(System.in);
		if(S.hasNextLine())
		{
			String selection = S.nextLine();
			studentAnswer = (SAAnswer) getNewAnswer(selection);
		}	
	}
	
	@Override
	public void getAnswerFromStudent(String studentAnswerText) {
		studentAnswer = (SAAnswer) getNewAnswer(studentAnswerText);
	}
	
	

		
	public void save(PrintWriter write) 
	{
		write.println("SAQuestion");
		write.println(maxValue);
		write.println(questions);
		rightAnswer.save(write);	
	}
	
	public double getValue() 
	{
		if(rightAnswer.getCredit(studentAnswer) == 1.0)
		{
			return maxValue;
		}
		else
		{
			return 0.0;
		}
	}

	



}
