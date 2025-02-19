package hello.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.repository.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberSaveControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        
        Member member = new Member(username, age);
        memberRepository.save(member);
        
        //  Model에 데이터를 보관한다.
        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
