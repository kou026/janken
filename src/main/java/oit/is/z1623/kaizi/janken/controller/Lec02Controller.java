package oit.is.z1623.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1623.kaizi.janken.model.Janken;
import oit.is.z1623.kaizi.janken.model.Match;
import oit.is.z1623.kaizi.janken.model.MatchMapper;
import oit.is.z1623.kaizi.janken.model.User;
import oit.is.z1623.kaizi.janken.model.UserMapper;

@Controller
public class Lec02Controller {

  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMapper matchMapper;

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
    ArrayList<User> users = userMapper.selectAll();
    model.addAttribute("users", users);
    ArrayList<Match> matches = matchMapper.selectAll();
    model.addAttribute("matches", matches);
    return "lec02.html";
  }

  @GetMapping("/match")
  @Transactional
  public String match(@RequestParam Integer id, @RequestParam(required = false) String hand, ModelMap model,
      Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);

    User user = userMapper.selectAllById(id);
    model.addAttribute("user", user);

    if (hand != null) {
      Janken janken = new Janken(hand);
      model.addAttribute("janken", janken);

      Match match = new Match(2, id, "Gu", hand);
      matchMapper.insertMatch(match);
      model.addAttribute(match);
    }

    return "match.html";
  }
}
