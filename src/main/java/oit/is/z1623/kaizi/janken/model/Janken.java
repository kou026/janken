package oit.is.z1623.kaizi.janken.model;

public class Janken {
  public String hand;
  public String result;

  public Janken(String yourHand) {
    this.hand = yourHand;
    switch (this.hand) {
      case "Gu":
        this.result = "Draw";
        break;
      case "Choki":
        this.result = "You Lose...";
        break;
      default:
        this.result = "You Win!!";
        break;
    }
  }
}
