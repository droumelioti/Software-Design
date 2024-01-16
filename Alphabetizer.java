import java.util.Set;
import java.util.TreeSet;

public class Alphabetizer extends Subject implements Observer {
	private Set<String> sortedLines = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

	private void sort(Message message) {
		String string = message.getString();
		sortedLines.add(string);
	}

	private void sendSortedLines(Message message) {
		for (String line : sortedLines) {
			notifyAllObservers(new Message(line));
		}
		notifyAllObservers(message);
	}

	@Override
	public void update(Message message) {
		if (message.isFinished()) {
			sendSortedLines(message);
		} else {
			sort(message);
		}
	}
}
