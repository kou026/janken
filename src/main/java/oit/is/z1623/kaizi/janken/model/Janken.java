package oit.is.z1623.kaizi.janken.model;

public class Janken {
  public String result;

  public Janken(String hand) {
    if (hand == "ぐー") {
      result = "Draw";
    }
    if (hand == "ちょき") {
      result = "You Lose...";
    }
    if (hand == "ぱー") {
      result = "You Win!!";
    }
  }
}
