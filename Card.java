
public class Card 
{
	public String cardValue; // face up
	public String flipped =""; // face down
	public String getRevealed() {
		return cardValue;
	}
	public void setRevealed(String revealed) {
		this.cardValue = revealed;
	}
	public String getFlipped() {
		return flipped;
	}
	public void setFlipped(String flipped) {
		this.flipped = flipped;
	}
	
	public Card (String revealed)
	{
		this.cardValue = revealed; // Name of the card
		this.flipped = "";
	}
	
}
