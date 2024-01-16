public class Message {
	private String string;
	private Boolean finished;

	public Message(String textMessage) {
		this.string = textMessage;
		this.finished = false;
	}

	public Message(Boolean boolMessage) {
		this.finished = boolMessage;
		this.string = null;
	}

	public String getString() {
		if (string == null) {
			throw new IllegalStateException();
		}
		return string;
	}

	public Boolean isFinished() {
		return finished;
	}
}
