package dev.lime.mutsa5.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)


@Table(name = "members")
@Entity
public class Member {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  private String name;

  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();
}











