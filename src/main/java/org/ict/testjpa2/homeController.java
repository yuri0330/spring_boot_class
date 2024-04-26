package org.ict.testjpa2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/boardpage")
    public String moveBoardPage() {
        return "board";
    }
    @GetMapping("/noticepage")
    public String moveNoticePage(){
        return "notice";
    }

    @GetMapping("/memberpage")
    public String moveMemberPage() {
        return "member";
    }

}
