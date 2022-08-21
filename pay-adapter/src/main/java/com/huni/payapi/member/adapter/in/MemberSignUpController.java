package com.huni.payapi.member.adapter.in;

import com.huni.payapi.member.adapter.in.dto.MemberSignUpRequest;
import com.huni.paycore.member.application.port.in.MemberSignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberSignUpController {

    private final MemberSignUpUseCase memberSignUpUseCase;

    @PostMapping("/api/members/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody MemberSignUpRequest memberSignUpRequest) {
        memberSignUpUseCase.signUp(memberSignUpRequest.toCommand());
        return ResponseEntity.ok().build();
    }
}
