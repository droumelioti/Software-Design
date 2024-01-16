import java.io.IOException;

public class MasterControl {
	public static void main(String[] args) throws IOException {
		MasterControl masterControl = new MasterControl();
		masterControl.start();
	}

	public void start() throws IOException {
		Input input = new Input();
		CircularShifter circularShifter = new CircularShifter();
		Alphabetizer alphabetizer = new Alphabetizer();
		Output output = new Output();

		input.attach(circularShifter);
		circularShifter.attach(alphabetizer);
		alphabetizer.attach(output);

		input.read();
	}
}
