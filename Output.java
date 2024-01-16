import java.io.FileWriter;
import java.io.IOException;

public class Output implements Observer {
	private FileWriter fileWriter;

	Output() throws IOException {
		fileWriter = new FileWriter("kwic_output.txt");
	}

	private void write(String line) throws IOException {
		fileWriter.write(line);
		fileWriter.write("\n");
	}

	private void writeToOutput(String line) {
		try {
			write(line);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void closeFileWriter() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Message message) {
		if (message.isFinished()) {
			closeFileWriter();
		} else {
			writeToOutput(message.getString());
		}
	}
}
