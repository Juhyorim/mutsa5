package dev.lime.mutsa5.controller;

import dev.lime.mutsa5.dto.MemberDto;
import dev.lime.mutsa5.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/members/{member_id}")
  public ResponseEntity getMember(@PathVariable("member_id") Long memberId) {
    return ResponseEntity.ok().build();
  }

  @PostMapping("/members")
  public ResponseEntity addMember(@RequestBody Map<String, String> member) throws Exception {
    if (member.get("name") == null)
      throw new Exception("name은 필수임");

    Long memberId = memberService.addMember(member.get("name"));

    Map<String, Long> map = new HashMap<>();
    map.put("member_id", memberId);

    return ResponseEntity.ok().body(map);
  }

  @PatchMapping("/members")
  public ResponseEntity editMember(@RequestBody MemberDto dto) throws Exception{
    memberService.editMember(dto);

    return ResponseEntity.ok().build();
  }
}
