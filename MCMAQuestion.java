
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;

public class MCMAQuestion extends MCQuestion {

	protected ArrayList<MCMAAnswer> studentAnswer = new ArrayList<MCMAAnswer>();
	protected double baseCredit;
	protected int ansNum;
	
	protected MCMAQuestion(String question, double val, double base)
	{
		super(question, val);
		this.baseCredit = base;
	}
	
	protected MCMAQuestion(Scanner scanner) 
	{
		super(scanner);
		baseCredit = scanner.nextDouble();
		ansNum = scanner.nextInt();
		int i;
		for(i = 0; i < ansNum; i++)
		{
			MCMAAnswer answer = new MCMAAnswer(scanner);
			answers.add(answer);
		}
	}
	
	public Answer getNewAnswer(String answer, double val)
	{
		MCMAAnswer ans = new MCMAAnswer(answer, val);
		return ans;
	}
	
	public Answer getNewAnswer()
	{
		MCMAAnswer ans = new MCMAAnswer(questions, maxValue);
		return ans;
	}
	
	public void getAnswerFromStudent()
	{
		super.print();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose your answers and then type done# (for example: 'a b c done#') ");
		String text = scanner.next();
		while(text.equalsIgnoreCase("done#") == false)
		{
			
			System.out.println(text + " ");
			switch(text)
			{
				case "A": studentAnswer.add((MCMAAnswer) answers.get(0)); break;
				case "a": studentAnswer.add((MCMAAnswer) answers.get(0)); break;
				case "B": studentAnswer.add((MCMAAnswer) answers.get(1)); break;
				case "b": studentAnswer.add((MCMAAnswer) answers.get(1)); break;
				case "C": studentAnswer.add((MCMAAnswer) answers.get(2)); break;
				case "c": studentAnswer.add((MCMAAnswer) answers.get(2)); break;
				case "D": studentAnswer.add((MCMAAnswer) answers.get(3)); break;
				case "d": studentAnswer.add((MCMAAnswer) answers.get(3)); break;
				case "E": studentAnswer.add((MCMAAnswer) answers.get(4)); break;
				case "e": studentAnswer.add((MCMAAnswer) answers.get(4)); break;
			}
			text = scanner.next();
		}
	}
	
	@Override
	public void getAnswerFromStudent(String studentAnswerText) {
		for(MCAnswer answer : answers){
			if(answer.answers.equals(studentAnswerText)){
				studentAnswer.add((MCMAAnswer)answer);
				break;
			}
		}
	}
	
	public void save(PrintWriter write) 
	{
		write.println("MCMAQuestion");
		write.println(maxValue);
		write.println(questions);
		write.println(baseCredit);
		write.println(ansNum);
		super.save(write);
	}
	
	public double getValue()
	{
		double added = 0;
		for(MCMAAnswer ques : studentAnswer)
		{
			added += super.getValue(ques);
		}
		added += baseCredit;
		return added;
	}
	
	public void restoreStudentAnswers(Scanner scanner)
	{
		if(scanner.hasNextLine() == false)
		{
			return;
		}
		scanner.nextLine();
		if(scanner.hasNextLine() == false)
		{
			return;
		}
		String questionType = scanner.nextLine();
		int numAns = scanner.nextInt();
		scanner.nextLine();
		int i;
		for(i = 0; i < numAns; i++)
		{
			String text = scanner.nextLine();
			text.replaceAll("\\s","");
			for(MCAnswer ans: answers)
			{
				if(ans.answers.equalsIgnoreCase(text));
				studentAnswer.add((MCMAAnswer) ans);
			}
		}
	}
	
	public void saveStudentAnswers(PrintWriter write)
	{
		
		write.println("MCMAAnswer");
		write.println(studentAnswer.size());
		for(MCMAAnswer ans: studentAnswer)
		{
			ans.save(write);
		}
	}

	
}
