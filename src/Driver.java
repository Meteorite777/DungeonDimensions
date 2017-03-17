import javax.sound.sampled.Clip;


public class Driver {
	
	public static void main(String[] args) {
		 System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		SoundClipTest test = new SoundClipTest("CS341_project.wav");
		test.repeat();
		StartScreen frame = new StartScreen(test);
		frame.setVisible(true);
	}
}
