
import java.io.FileReader;
import java.io.IOException;

public class SimpleCalcFile {

	public static void main(String[] args) {
		String[] s = {"", "", ""};
		
		/*
		Scanner in = new Scanner(System.in);
		
		
		s[0] = in.next();
		s[2] = in.next();
		s[1] = in.next();
		*/
		try(FileReader reader = new FileReader("d:\\notes3.txt"))
        {
           // читаем посимвольно
			char cbuf[] = new char[256];
            int k = reader.read(cbuf);
            String sbuf = String.copyValueOf(cbuf);
            sbuf = sbuf.substring(0, k);
            s = sbuf.split(" ");
            sbuf = s[2];
            s[2] = s[1];
            s[1] = sbuf;
            
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }   
		
		double[] dm = new double[2];
		
		boolean work = true;
		
		for (int i = 0; i < 2; i++) {
			try {	
			dm[i] = Double.parseDouble(s[i]); 
			}	
		
		catch (NumberFormatException n1) {
			System.out.println("Error! Not number");
			work = false;
			break;
		}
		}

		
		if (!work) {}
		else if (s[2].equals("+")) {
			System.out.println(dm[0] + dm[1]);
		}
		else if (s[2].equals("-")) {
			System.out.println(dm[0] - dm[1]);
		}
		else if (s[2].equals("/")) {
			/*
			int comp = 0;
			
			comp = Double.compare(dm[1], 0);
			
			if (comp == 0) {
				
			}
			*/
			
			double ans = dm[0] / dm[1];
			
			if (Double.isNaN(ans) || Double.isFinite(ans) 
					|| Double.isInfinite(ans)) {
				System.out.println("Error! Division by zero");
				
			}
			else {			
			System.out.println(ans);
			}
		}
		else if (s[2].equals("*")) {
			System.out.println(dm[0] * dm[1]);
		}
		else {
			System.out.println("Operation Error!");
		}
		
		

	}

}
