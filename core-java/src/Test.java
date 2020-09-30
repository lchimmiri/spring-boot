import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException {

		Process p = Runtime.getRuntime().exec("ssh 127.0.0.1");
		PrintStream out = new PrintStream(p.getOutputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

		out.println("ls -l /home/");
		while (in.ready()) {
		  String s = in.readLine();
		  System.out.println(s);
		}
		out.println("exit");

		p.waitFor();
	}

}
