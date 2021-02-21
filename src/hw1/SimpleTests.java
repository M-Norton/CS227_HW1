package hw1;
/**
 * Some basic usage examples for the TV class.
 */
public class SimpleTests
{
  public static void main(String[] args)
  {
    // try volumeUp
    TV tv = new TV(0, 5);
    System.out.print(tv.getVolume()); // expected 0.5
    System.out.println(" : expected value 0.5");
    tv.volumeUp();
    tv.volumeUp();
    System.out.print(tv.getVolume()); // expected 0.64
    System.out.println(" : expected value 0.64");
    tv.volumeUp();
    tv.volumeUp();
    tv.volumeUp();
    tv.volumeUp();
    tv.volumeUp();
    tv.volumeUp();
    System.out.print(tv.getVolume()); // expected 1.0
    System.out.println(" : expected value 1.0");
    System.out.println();
    
    // try getting and setting channel
    tv = new TV(2, 10);
    System.out.print(tv.getChannel());  // expected 2
    System.out.println(" : expected value 2");
    tv.setChannel(8);
    System.out.print(tv.getChannel());  // expected 8
    System.out.println(" : expected value 8");
    tv.setChannel(42);
    System.out.print(tv.getChannel());  // expected 11
    System.out.println(" : expected value 11");
    tv.setChannel(1);
    System.out.print(tv.getChannel());  // expected 2
    System.out.println(" : expected value 2");
    System.out.println();
    
    // try channelUp
    tv = new TV(2, 10);
    tv.setChannel(8);
    tv.channelUp();
    System.out.print(tv.getChannel());  // expected 9
    System.out.println(" : expected value 9");
    tv.channelUp();
    System.out.print(tv.getChannel());  // expected 10
    System.out.println(" : expected value 10");
    tv.channelUp();
    System.out.print(tv.getChannel());  // expected 11
    System.out.println(" : expected value 11");
    tv.channelUp();
    System.out.print(tv.getChannel());  // expected 2
    System.out.println(" : expected value 2");
    System.out.println();
    
    // try channelDown
    tv.setChannel(4);
    tv.channelDown();
    System.out.print(tv.getChannel());  // expected 3
    System.out.println(" : expected value 3");
    tv.channelDown();
    System.out.print(tv.getChannel());  // expected 2
    System.out.println(" : expected value 2");
    tv.channelDown();
    System.out.print(tv.getChannel());  // expected 11
    System.out.println(" : expected value 11");
    System.out.println();
    
    // try resetNumChannels
    tv = new TV(2, 10);
    tv.setChannel(8);
    tv.resetNumChannels(5);
    System.out.print(tv.getChannel());  // should now be 6
    System.out.println(" : expected value 6");
    System.out.print(tv.display());
    System.out.println(" : expected \"Channel 6 Volume 50%\"");
    
    // try resetStart
    tv = new TV(2, 10);
    tv.setChannel(8);
    tv.resetStart(10);
    System.out.print(tv.getChannel());  // should now be 10
    System.out.println(" : expected value 10");
    System.out.print(tv.display());
    System.out.println(" : expected \"Channel 10 Volume 50%\"");
    
    tv = new TV(2, 10);
    tv.setChannel(8);
    tv.resetStart(-5);
    System.out.print(tv.getChannel());  // should now be 4
    System.out.println(" : expected value 4");
    System.out.print(tv.display());
    System.out.println(" : expected \"Channel 4 Volume 50%\"");

  }
}
