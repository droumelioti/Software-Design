import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Input extends Subject {
	public void read() throws IOException {

		File file = new File("kwic.txt");
		Scanner reader = new Scanner(file);

		while (reader.hasNextLine()) {
			Message line = new Message(reader.nextLine());
			notifyAllObservers(line);
		}
		reader.close();
		notifyAllObservers(new Message(true));
	}
}
