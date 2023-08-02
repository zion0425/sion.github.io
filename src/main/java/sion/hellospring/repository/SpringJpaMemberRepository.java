package sion.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sion.hellospring.domain.Member;

import java.util.Optional;

public interface SpringJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
