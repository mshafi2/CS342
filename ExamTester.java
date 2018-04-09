
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class ExamTester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//print info
		System.out.println("Name: Mohammed Shafiuddin");
		System.out.println("Net Id: mshafi2 ");
		System.out.println("Project 4");
		System.out.println("");
		System.out.print("Enter file name: ");
		
		
		Scanner exam = ScannerFactory.getKeyboardScanner();
		File newFile = new File(exam.nextLine());
		exam = new Scanner(newFile);
		
		
		//create exams with details about each exam
		Exam exam1= new Exam(exam);
		
		exam1.print();
		exam1.reorderQuestions();
		exam1.reorderMCAnswers(-1);
		exam1.print();
		
		File savedFileExam = new File("savedExam.txt");
		PrintWriter write = new PrintWriter(savedFileExam);
		
		File savedFileAnswer = new File("saveAnswerFile.txt");
		PrintWriter write2 = new PrintWriter(savedFileAnswer);
		
		write2.println("Mohammed Shafiudddin");
		write2.println("savedExam.txt");
		exam1.save(write);
		System.out.println("");
		System.out.print("Take the exam: ");
		System.out.println("");
		
		exam1.getAnswerFromStudent(-1);
		exam1.saveStudentAnswers(write2);
		write2.close();
		write.close();
		
		Scanner exam2 = ScannerFactory.getKeyboardScanner();
		File examFile = new File("savedExam.txt");
		Scanner answer2 = ScannerFactory.getKeyboardScanner();
		File answerFile = new File("saveAnswerFile.txt");
		
		exam2 = new Scanner(examFile);
		Exam examTwo = new Exam(exam2);
		
		answer2 = new Scanner(answerFile);
		examTwo.restoreStudentAnswers(answer2);
		
		examTwo.reportQuestionValues();
		examTwo.getValue();
		
	}
}
