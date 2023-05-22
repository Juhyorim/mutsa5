package dev.lime.mutsa5.repository;

import dev.lime.mutsa5.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
