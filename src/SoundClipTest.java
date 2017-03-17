import java.io.*;
import java.net.URL;

import javax.sound.sampled.*;
import javax.swing.*;   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundClipTest extends JFrame {
   
	private Clip clip;
   // Constructor
   public SoundClipTest(String f) { 
      try {
         // Open an audio input stream.
    	  File soundFile = new File(f);
    	  AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         // Get a sound clip resource.
          clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }      
   }
   public void playOnce(){
 	  clip.start();
   }
   public void turnOff(){
	   clip.stop();
   }
   public void repeat(){
	   clip.loop(Clip.LOOP_CONTINUOUSLY);
   }
}