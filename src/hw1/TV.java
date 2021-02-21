package hw1;
import java.lang.Math;
import java.lang.String;


/**
 * Model of a TV with volume and channel functions.
 * @author Matt Norton
 */
public class TV {
	
	private int start;
	private int channel;
	private int numChannels;
	private int previousChannel;
	private double volume = 0.5;
	public static final double VOLUME_INCREMENT = 0.07;
	
	
	/**
	   * A TV with a given starting channel and number of channels.
	   * @param givenStart 
	   *   The starting channel in the range of channels for this TV.
	   * @param givenChannels
	   *   The total number of channels available for this TV.
	   */
	public TV(int givenStart, int givenChannels) {
		start = givenStart;
		channel = start;
		numChannels = givenChannels;
	}
	
	
	 // --------v------- VOLUME METHODS --------v-------
	
	
	/**
	 * Lowers the volume by VOLUME_INCREMENT, but not below 0.0.
	 */
	public void volumeDown() {
		volume -= VOLUME_INCREMENT;
		volume = Math.min(volume, 1.0);
		volume = Math.max(volume, 0.0);
	}
	
	
	/**
	 * Raises the volume by VOLUME_INCREMENT, but not above 1.0.
	 */
	public void volumeUp() {
		volume += VOLUME_INCREMENT;
		volume = Math.min(volume, 1.0);
		volume = Math.max(volume, 0.0);
	}
	
	
	/**
	 * Returns the current volume of the TV.
	 * @return
	 *   Returns a double value 0.0 - 1.0 of the current 
	 *   volume level.
	 */
	public double getVolume() {
		return volume;
	}
	
	
	// --------v------- CHANNEL METHODS --------v-------
	
	
	/**
	 * Changes the channel down by 1, wrapping around
	 * to start if the current channel is start + numChannales -1.
	 */
	public void channelDown() {
		previousChannel = channel;
		channel = (((channel-start) - 1) + numChannels) % numChannels;
		channel += start;
	}
	
	
	/**
	 * Changes the channel up by 1, wrapping around to start if 
	 * the current channel is start + numChannels -1.
	 */
	public void channelUp() {
		previousChannel = channel;
		channel = ((channel-start) + 1) % (numChannels);
		channel += start;
	}
	
	
	/**
	 * Returns the current channel.
	 * @return
	 *   Returns an integer value for the current channel.
	 */
	public int getChannel() {
		return channel;
	}
	
	
	/**
	 * Sets the channel to the given number. However, if the 
	 * given value is greater than start+numChannels-1, it 
	 * is set to start+numChannels-1, and if the given value
	 * is less than start, it is set to start.
	 * @param channelNumber
	 *   The current channel number of this TV.
	 */
	public void setChannel(int channelNumber) {
		previousChannel = channel;
		channel = Math.max(channelNumber,  start);
		channel = Math.min(channel, (start+numChannels-1));
	}
	
	
	/**
	 * Resets this TV so that its available channels are now from 
	 * start through start+givenNumChannels-1. If the current 
	 * channel or previous channel is outside the new range of 
	 * channel numbers, their values are adjusted to be the
	 * nearest value within the new range.
	 * @param givenNumChannels
	 *   The number a channels available on this TV.
	 */
	public void resetNumChannels(int givenNumChannels) {
		numChannels = givenNumChannels;
		channel = Math.max(channel, start);
		channel = Math.min(channel, (start + numChannels - 1));
	}
	
	
	/**
	 * Resets this TV so that its available channels are now
	 * from givenStart through givenStart + numChannels-1.
	 * If the current channel or previous channel is outside
	 * the new range of channel numbers, their values are
	 * adjusted to be the nearest value within the new range.
	 * @param givenStart
	 *   The start channel for this TV.
	 */
	public void resetStart(int givenStart) {
		start = givenStart;
		channel = Math.max(channel, start);
		channel = Math.min(channel, (start + numChannels - 1));
	}
	
	
	/**
	 * Sets the current channel to the most previous channel.
	 * If no channel has been set for this TV using one of 
	 * the methods channelDown, channelUp, or setChannel,
	 * this method sets the channel to start!
	 */
	public void goToPreviousChannel() {
		channel = Math.max(previousChannel, start);
		channel = Math.min(channel, (start + numChannels - 1));	
	}
	
	
	/**
	 * Returns a string representing the current channel and volume.
	 * @return
	 *   A string representing the current channel and volume 
	 *   in the form of "Channel x Volume y%". Where x is the 
	 *   current channel and y is the volume multiplied by 100
	 *   and rounded to the nearest integer (0.765 -> 77%).
	 */
	public String display() {
		String display = "Channel " + channel + " Volume " + (int)Math.round(volume*100) + "%";
		return display;
	}
}
