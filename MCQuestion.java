import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter;
import java.util.Scanner;

abstract class MCQuestion extends Question{
	
	protected ArrayList<MCAnswer> answers = new ArrayList<MCAnswer>();
	
	
	protected MCQuestion(String question, double val)
	{
		super(question, val);
	}
	
	protected MCQuestion(Scanner scanner)
	{
		super(scanner);
	}
	
	public void print() 
	{
		
		int i;
		System.out.println(questions);
		for(i=0; i <= answers.size()-1; i++ )
		{
			System.out.print("  " + (char)('A' + i) + ".");
			answers.get(i).print();
		}
	}
	
	public void addAnswer(MCAnswer array)
	{
		answers.add(array);
	}
	
	public void reorderAnswers()
	{
		Collections.shuffle(answers);
	}
	
	public double getValue(MCAnswer ansStudent)
	{
		for(MCAnswer iter : answers)
		{
			if (iter.getCredit(ansStudent) != 0.0)
			{
				return iter.getCredit(ansStudent) * maxValue;
			}
		}
		return 0.0;
	}
	
	public void save(PrintWriter write)
	{
		for(MCAnswer iter: answers)
		{
			write.print(iter.creditIfSelected + " ");
			write.println(iter.answers);
		}
	}
	
	
	

}
