package sion.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sion.hellospring.service.MemberService;

// Spring Container에서 Spring bin이 관리된다.
@Controller
public class MemberController {
    private final MemberService memberService;

    // Spring bin에 등록되어 있는 것을 @Service 객체를 연결한다. == Dependency Injection
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
