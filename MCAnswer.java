
import java.io.PrintWriter;
import java.util.Scanner;

abstract class MCAnswer extends Answer{

	protected String answers;
	protected double creditIfSelected;
	
	protected MCAnswer(String answer, double credit)
	{
		this.answers = answer;
		creditIfSelected = credit;
	}
	
	public MCAnswer(Scanner scanner)
	{
		creditIfSelected = scanner.nextDouble();
		answers = scanner.nextLine();
		answers = answers.trim();
	}
	
	public double getCredit(Answer ansStudent)
	{
		if(this == ansStudent)
			return creditIfSelected;
		else
			return 0.0;		
	}
	
	public void print() 
	{
		System.out.println(answers);
	}
	
	public void save(PrintWriter write)
	{
		write.println(answers);
	}
	
}
