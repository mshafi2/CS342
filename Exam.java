
import java.util.ArrayList;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class Exam {
	
	//Private members for Exam class with an arraylist of type Question
	private String exams;
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	
	//constructor for Exam class
	public Exam(String exam)
	{
		this.exams = exam;
	}
	
	Exam(Scanner scanner)
	{
		exams = scanner.nextLine();
		
		//Skip timestamp
		scanner.nextLine();
		
		while(scanner.hasNextLine())
		{
			scanner.nextLine();
			
			if(scanner.hasNextLine() == false)
			{
				break;
			}
			String typeOfQuestion = scanner.nextLine();
			if(scanner.hasNextLine() == false)
			{
				break;
			}
			if(typeOfQuestion.equalsIgnoreCase("SAQuestion"))
			{
				SAQuestion ques = new SAQuestion(scanner);
				addQuestion(ques);
			}
			else if(typeOfQuestion.equalsIgnoreCase("MCSAQuestion"))
			{
				MCSAQuestion ques = new MCSAQuestion(scanner);
				addQuestion(ques);
			}
			else if(typeOfQuestion.equalsIgnoreCase("MCMAQuestion"))
			{
				MCMAQuestion ques = new MCMAQuestion(scanner);
				addQuestion(ques);
			}
		}
	}
	//add a question to an exam
	public void addQuestion(Question array)
	{
		questions.add(array);
	}
	
	//prints the entire exam with all questions and their answers
	public void print() 
	{
		int i;
		System.out.println(exams);
		for(i=0; i < questions.size(); i++ )
		{
			System.out.print((i+1) + ".");
			questions.get(i).print();
			System.out.println("");
		}
	}
	
	
	//reorders the questions in the exam
	public void reorderQuestions()
	{
		Collections.shuffle(questions);
	}
	
	public void reorderMCAnswers(int pos)
	{
		if(pos < 0 )
		{
			for(Question ques : questions)
			{
				if(ques instanceof MCQuestion)
				{
					Collections.shuffle(((MCQuestion) ques).answers);
				}
			}
		}
		else 
		{
			Question ques = questions.get(pos);
			if(ques instanceof MCQuestion)
			{
				Collections.shuffle(((MCQuestion) ques).answers);
			}
		}
	}
	
	public void getAnswerFromStudent(int pos) 
	{
		if(pos < 0 )
		{
			for(Question ques : questions)
			{
				ques.getAnswerFromStudent();
			}
		}
		else
		{
			Question ques = questions.get(pos);
			ques.getAnswerFromStudent();
		}
	}
	
	public void getAnswerFromStudent(int questionPos, String studentAnswer) 
	{
		Question ques = questions.get(questionPos);
		ques.getAnswerFromStudent(studentAnswer);
	}
	
	//get the overall score of the exam
	public double getValue()
	{
		double value = 0.0;
		int counter = 1;
		
		for(Question ques : questions)
		{
			System.out.println(" " +ques.getValue() + " points from Question number: " + counter);
			value += ques.getValue();
			counter++;
		}
		
		System.out.println(" " + value + " points total.");
		return value;
	}
	
	public void reportQuestionValues() 
	{
		int position = 1;
		
		int i;
		for(i=0; i < questions.size(); i++)
		{
			System.out.println("Question number " + position + ": " + questions.get(i).maxValue + " points");
			position++;
		}
	}
	
	public void restoreStudentAnswers(Scanner scanner)
	{
		String name = scanner.nextLine();
		//Skip the exam file name and timestamp
		scanner.nextLine();
		scanner.nextLine();
		
		System.out.println("Restoring answers for: " + name);
		while(scanner.hasNextLine())
		{
			for(Question ques: questions)
			{
				ques.restoreStudentAnswers(scanner);
			}
		}
	}
	
	public void save(PrintWriter write)
	{
		write.println(exams);
		
		write.println(getTimestamp());
		
		write.println();
		for(Question ques: questions)
		{
			ques.save(write);
			write.println();
		}
	}
	
	private String getTimestamp(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		String timestamp = dateFormat.format(date);
		return timestamp;
	}

	public void saveStudentAnswers(PrintWriter write)
	{
		write.println(getTimestamp());
		int i;
		write.println();
		for(i=0; i < questions.size(); i++ )
		{
			questions.get(i).saveStudentAnswers(write);
			write.println();
		}
	}
	
	public ArrayList<Double> getAllQuestionValues(){
		ArrayList<Double> questionValues = new ArrayList<Double>();
		
		for(Question question: questions){
			questionValues.add(question.getValue());
		}
		
		return questionValues;
	}
		
}
