
import java.util.Scanner;

public class ScannerFactory {
	
	private static Scanner scan;
	
	public static Scanner getKeyboardScanner()
	{
		if(scan == null)
		{
			scan = new Scanner(System.in);
			return scan;
		}
		return scan;
	}
}