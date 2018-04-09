
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter;
import java.util.Scanner;

//Name: Tarang Patel
//Netid: tpatel31
//Project 1


public abstract class Question {
	
	protected String questions;
	protected Answer rightAnswer;
	protected Answer studentAnswer;
	protected double maxValue;
	
	protected Question(String question, double val) 
	{
		questions = question;
		maxValue = val;
	}
	
	public Question(Scanner scanner)
	{
		maxValue = scanner.nextDouble();
		scanner.nextLine();
		questions = scanner.nextLine();
		
	}
	
	
	
	public void print()
	{
		System.out.print(questions);
		System.out.println("");
	}
	
	public void setRightAnswer(Answer ans)
	{
		rightAnswer = ans;
	}
	
	public abstract Answer getNewAnswer();
	
	public abstract void getAnswerFromStudent();
	
	public abstract void getAnswerFromStudent(String studentAnswerText);
	
	public abstract double getValue();
	
	abstract public void save(PrintWriter write);
	
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
		String typeOfQuestion = scanner.nextLine();
		switch(typeOfQuestion)
		{
			case "SAAnswer": String text = scanner.nextLine();
								studentAnswer = new SAAnswer(text); break;
			case "MCSAAnswer": String text2 = scanner.nextLine();
								text = text2.replaceAll("\\s","");
								MCSAQuestion ques = (MCSAQuestion) this;
								if(text.equalsIgnoreCase(ques.answers.get(0).answers.replaceAll("\\s","")))
								{
									studentAnswer = ques.answers.get(0);
								}
								else if(text.equalsIgnoreCase(ques.answers.get(1).answers.replaceAll("\\s","")))
								{
									studentAnswer = ques.answers.get(1);
								}
								else if(text.equalsIgnoreCase(ques.answers.get(2).answers.replaceAll("\\s","")))
								{
									studentAnswer = ques.answers.get(2);
								}
								else if(text.equalsIgnoreCase(ques.answers.get(3).answers.replaceAll("\\s","")))
								{
									studentAnswer = ques.answers.get(3);
								}
								else if(text.equalsIgnoreCase(ques.answers.get(4).answers.replaceAll("\\s","")))
								{
									studentAnswer = ques.answers.get(4);
								} break;
			}
	}
	
	
	public void saveStudentAnswers(PrintWriter write)
	{
		if(this instanceof SAQuestion)
		{
			write.println("SAAnswer");
			studentAnswer.save(write);
		}
		else if(this instanceof MCSAQuestion)
		{
			write.println("MCSAAnswer");
			studentAnswer.save(write);
		}
		
	}
	
}
