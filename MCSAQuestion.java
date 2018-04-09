
import java.io.PrintWriter;
import java.util.Scanner;

public class MCSAQuestion extends MCQuestion {
	
	private int ansNum;
	
	protected MCSAQuestion(String question, double val)
	{
		super(question,val);
	}
	
	protected MCSAQuestion(Scanner scanner)
	{
		super(scanner);
		
		ansNum = scanner.nextInt();
		int i;
		for(i = 0; i < ansNum; i++)
		{
			MCSAAnswer answer = new MCSAAnswer(scanner);
			answers.add(answer);
		}
	}

	
	public Answer getNewAnswer() 
	{
		
		MCSAAnswer answer = new MCSAAnswer(questions, maxValue);
		return answer;
	}
	
	public Answer getNewAnswer(String ans, double credit) 
	{
		
		MCSAAnswer answer = new MCSAAnswer(ans, credit);
		return answer;
	}

	public void selectRightAnswer(Answer answer) 
	{
		rightAnswer = answer;
	}
	
	public void getAnswerFromStudent() 
	{
		super.print();
		
		Scanner scanner = new Scanner(System.in);
		String text=scanner.nextLine();
		
		
		switch (text) 
		{
			case "A": studentAnswer = answers.get(0); break;
			case "a": studentAnswer = answers.get(0); break;
			case "B": studentAnswer = answers.get(1); break;
			case "b": studentAnswer = answers.get(1); break;
			case "C": studentAnswer = answers.get(2); break;
			case "c": studentAnswer = answers.get(2); break;
			case "D": studentAnswer = answers.get(3); break;
			case "d": studentAnswer = answers.get(3); break;
			case "E": studentAnswer = answers.get(4); break;
			case "e": studentAnswer = answers.get(4); break;
		}
		System.out.print("You selected: ");
		studentAnswer.print();
		
	}
	
	@Override
	public void getAnswerFromStudent(String studentAnswerText) {
		for(MCAnswer answer : answers){
			if(answer.answers.equals(studentAnswerText)){
				studentAnswer = answer;
				break;
			}
		}
	}
    
	public void save(PrintWriter write) 
	{
		// TODO Auto-generated method stub
		write.println("MCSAQuestion");
		write.println(maxValue);
		write.println(questions);
		write.println(ansNum);
		super.save(write);
	}
	
	
	public double getValue() 
	{
		return super.getValue((MCSAAnswer)studentAnswer);
	}

	

}
