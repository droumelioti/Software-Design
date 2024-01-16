public class CircularShifter extends Subject implements Observer {
	private void shiftLine(Message line) {
		notifyAllObservers(line);

		String[] words = line.getString().split(" ");

		for (int i = 0; i < words.length - 1; i++) {
			String shiftedLine = createNewShiftedLine(words);
			Message newMessage = new Message(shiftedLine);
			notifyAllObservers(newMessage);
		}
	}

	private String createNewShiftedLine(String[] words) {
		String firstWord = words[0];
		String shiftedLine = "";

		for (int i = 0; i < words.length - 1; i++) {
			words[i] = words[i + 1];
			shiftedLine = shiftedLine + words[i + 1] + " ";
		}

		words[words.length - 1] = firstWord;
		shiftedLine = shiftedLine + firstWord;

		return shiftedLine;
	}

	@Override
	public void update(Message message) {
		if (message.isFinished()) {
			notifyAllObservers(message);
		} else {
			shiftLine(message);
		}
	}
}
