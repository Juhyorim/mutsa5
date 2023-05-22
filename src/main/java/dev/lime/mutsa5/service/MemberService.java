package dev.lime.mutsa5.service;

import dev.lime.mutsa5.domain.Member;
import dev.lime.mutsa5.dto.MemberDto;
import dev.lime.mutsa5.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberService {
  private final MemberRepository memberRepository;

  @Transactional
  public Long addMember(String name) {
    Member newMember = Member.builder()
      .name(name)
      .build();

    memberRepository.save(newMember);

    return newMember.getId();
  }

  @Transactional(readOnly = true)
  public Member getMember(Long memberId)  throws Exception{
    Member member = memberRepository.findById(memberId)
      .orElseThrow(() -> new Exception());

    return member;
  }

  @Transactional
  public void editMember(MemberDto dto) throws Exception {
    Member member = memberRepository.findById(dto.getMember_id())
      .orElseThrow(() -> new Exception());

    member.setName(dto.getName());
  }




}
