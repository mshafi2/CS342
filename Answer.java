import java.io.PrintWriter;
import java.util.Scanner;




public abstract class Answer {
	
	protected Answer() 
	{
		
	}
	
	public Answer(Scanner scanner)
	{
		
	}
	
	public abstract void print();
	
	public abstract double getCredit(Answer rightAnswer);
	
	abstract public void save(PrintWriter write);
}
