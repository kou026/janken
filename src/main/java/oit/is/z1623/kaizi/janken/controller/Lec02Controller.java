package oit.is.z1623.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1623.kaizi.janken.model.Janken;
import oit.is.z1623.kaizi.janken.model.Entry;

@Controller
public class Lec02Controller {

  @Autowired
  private Entry entry;

  /*
   * @param model Thymeleafにわたすデータを保持するオブジェクト
   *
   * @param prin ログインユーザ情報が保持されるオブジェクト
   *
   * @return
   */

  @GetMapping("/lec02")
  public String lec02(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);
    this.entry.addUser(loginUser);
    model.addAttribute("entry", this.entry);
    return "lec02.html";
  }

  @GetMapping("/gu")
  public String gu(ModelMap model) {
    String hand = "ぐー";
    Janken janken = new Janken(hand);

    model.addAttribute("yourhand", hand);
    model.addAttribute("result", janken.result);
    return "lec02.html";
  }

  @GetMapping("/choki")
  public String choki(ModelMap model) {
    String hand = "ちょき";
    Janken janken = new Janken(hand);

    model.addAttribute("yourhand", hand);
    model.addAttribute("result", janken.result);
    return "lec02.html";
  }

  @GetMapping("/pa")
  public String pa(ModelMap model) {
    String hand = "ぱー";
    Janken janken = new Janken(hand);

    model.addAttribute("yourhand", hand);
    model.addAttribute("result", janken.result);
    return "lec02.html";
  }
}
