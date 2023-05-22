package dev.lime.mutsa5.dto;

import dev.lime.mutsa5.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDto {

  private Long member_id;
  private String name;

}
