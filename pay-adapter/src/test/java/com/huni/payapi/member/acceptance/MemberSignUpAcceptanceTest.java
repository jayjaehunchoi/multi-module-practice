package com.huni.payapi.member.acceptance;

import static com.huni.payapi.common.acceptance.RequestFixtures.post;
import static com.huni.payapi.common.member.MemberFixtures.EMAIL;
import static com.huni.payapi.common.member.MemberFixtures.NAME;
import static com.huni.payapi.common.member.MemberFixtures.PASSWORD;
import static org.assertj.core.api.Assertions.assertThat;

import com.huni.payapi.common.acceptance.AcceptanceTest;
import com.huni.payapi.member.adapter.in.dto.MemberSignUpRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class MemberSignUpAcceptanceTest extends AcceptanceTest {

    @DisplayName("회원가입에 성공한다.")
    @Test
    void signUp() {
        ExtractableResponse<Response> response = post("api/members/sign-up", new MemberSignUpRequest(NAME, EMAIL, PASSWORD));
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
